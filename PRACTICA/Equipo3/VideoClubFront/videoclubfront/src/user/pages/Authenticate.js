import React, { useState, useContext } from "react";
import { useHistory } from "react-router-dom";
import Input from "../../shared/components/FormElements/Input";
import Button from "../../shared/components/FormElements/Button";
import Card from "../../shared/components/UIElements/Card";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import {
  VALIDATOR_DNI,
  VALIDATOR_EMAIL,
  VALIDATOR_MINLENGTH,
  VALIDATOR_PASS,
  VALIDATOR_REQUIRE,
} from "../../shared/util/validators";
import { useForm } from "../../shared/hooks/form-hook";
import { AuthContext } from "../../shared/context/auth-context";
import { useHttpClient } from "../../shared/hooks/http-hook";

import "./Authenticate.css";

const Authenticate = (props) => {
  const auth = useContext(AuthContext);
  const [isLoginMode, setIsLoginMode] = useState(true);
  const { isLoading, error, sendRequest, clearError } = useHttpClient();
  const history = useHistory();
  const [passConfirm, setPassConfirm] = useState();

  const [formState, inputHandler, setFormData] = useForm(
    {
      username: {
        value: "",
        isValid: false,
      },
      password: {
        value: "",
        isValid: false,
      },
    },
    false
  );

  const switchModeHandler = () => {
    if (!isLoginMode) {
      setFormData(
        {
          ...formState.inputs,
          email: undefined,
          codigoInvitacion: undefined,
        },
        formState.inputs.username.isValid && formState.inputs.password.isValid
      );
    } else {
      setFormData(
        {
          ...formState.inputs,
          email: { value: "", isValid: false },
          codigoInvitacion: { value: "", isValid: false },
        },
        false
      );
    }

    setIsLoginMode((prevMode) => !prevMode);
  };

  const authSubmitHandler = async (event) => {
    event.preventDefault();

    if (isLoginMode) {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/login`,
          "POST",
          JSON.stringify({
            username: formState.inputs.username.value,
            password: formState.inputs.password.value,
            
          }),
          {
            "Content-Type": "application/json",
          }
        );
        auth.login(responseData.username, responseData.token, responseData.roles);
      } catch (err) {

      }
      if (props.close) {
        props.close();
      } else {
        history.push("/");
      }
    } else {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/registro`,
          "POST",
          JSON.stringify({
            username: formState.inputs.username.value,
            email: formState.inputs.email.value,
            password: formState.inputs.password.value,
            codigoInvitacion: formState.inputs.codigoInvitacion.value,
          }),
          {
            "Content-Type": "application/json",
          }
        );
  
      } catch (err) {}
    }
  };

  return (
    <React.Fragment>
      <ErrorModal error={error} onClear={clearError} />
      <Card className="authentication">
        {isLoading && <LoadingSpinner asOverlay />}
        <h2>Iniciar Sesión</h2>
        <form onSubmit={authSubmitHandler}>
          <Input
            element="input"
            id="username"
            type="text"
            label="Nombre de Usuario"
            validators={[VALIDATOR_REQUIRE]}
            errorText="Por favor, introduce un nombre"
            onInput={inputHandler}
          />
          {!isLoginMode && (
            <Input
              id="email"
              element="input"
              type="email"
              label="E-mail"
              validators={[VALIDATOR_EMAIL()]}
              errorText="Please enter a valid Email"
              onInput={inputHandler}
            />
          )}
          <Input
            id="password"
            element="input"
            type="password"
            label="Password"
            validators={[VALIDATOR_MINLENGTH(6)]}
            errorText="Por favor, introduce un password con mas de 6 caracteres ."
            onInput={inputHandler}
          />
          {!isLoginMode && (
            <React.Fragment>
              <Input
                id="password2"
                element="input"
                type="password"
                label="Confirmacion del password"
                validators={[VALIDATOR_PASS(formState.inputs.password.value)]}
                errorText="La contraseña introducida no coincide en los dos campos ."
                onInput={inputHandler}
              />
              <Input
                id="codigoInvitacion"
                element="input"
                type="text"
                label="Codigo de Invitacion"
                validators={[VALIDATOR_MINLENGTH(0)]}
                errorText="BLA ."
                onInput={inputHandler}
              />
            </React.Fragment>
          )}
          <Button type="submit">
            {isLoginMode ? "Iniciar" : "Registrarse"}
          </Button>
        </form>
        {!props.close && (
          <Button inverse onClick={switchModeHandler}>
            {isLoginMode ? "Cambiar a Registro" : "Cambiar a Inicio Sesion"}
          </Button>
        )}
      </Card>
    </React.Fragment>
  );
};

export default Authenticate;
