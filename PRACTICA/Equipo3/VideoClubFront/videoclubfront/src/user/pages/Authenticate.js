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

  const [formState, inputHandler, setFormData] = useForm(
    {
      email: {
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
          nombre: undefined,
          dni: undefined,
          telefono: undefined,
          direccion: undefined,
        },
        formState.inputs.email.isValid && formState.inputs.password.isValid
      );
    } else {
      setFormData(
        {
          ...formState.inputs,
          nombre: { value: "", isValid: false },
          dni: { value: "", isValid: false },
          telefono: { value: null, isValid: false },
          direccion: { value: "", isValid: false },
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
          // `${process.env.REACT_APP_BACKEND_URL}/users/login`,
          "POST",
          JSON.stringify({
            email: formState.inputs.email.value,
            password: formState.inputs.password.value,
          }),
          {
            "Content-Type": "application/json",
          }
        );
        auth.login(responseData.userId, responseData.token);
      } catch (err) {}
      if (props.close) {
        props.close();
      }
    } else {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/users/signup`,
          "POST",
          JSON.stringify({
            email: formState.inputs.email.value,
            password: formState.inputs.password.value,
            nombre: formState.inputs.title.value,
            dni: formState.inputs.dni.value,
            telefono: formState.inputs.telefono.value,
            direccion: formState.inputs.direccion.value,
          }),
          {
            "Content-Type": "application/json",
            Authorization: "Bearer " + auth.token,
          }
        );

        history.push("/" + auth.userId + "/places");
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
          {!isLoginMode && (
            <React.Fragment>
              <Input
                element="input"
                id="nombre"
                type="text"
                label="Nombre"
                validators={[VALIDATOR_REQUIRE]}
                errorText="Por favor, introduce un nombre"
                onInput={inputHandler}
              />
              <Input
                element="input"
                id="dni"
                type="text"
                label="NIF"
                validators={[VALIDATOR_DNI()]}
                errorText="Por favor, introduce un DNI o NIE  valido"
                onInput={inputHandler}
              />
              <Input
                element="input"
                id="telefono"
                type="text"
                label="Telefono de contacto"
                validators={[VALIDATOR_REQUIRE]}
                errorText="Por favor, introduce un telefono valido"
                onInput={inputHandler}
              />
              <Input
                element="input"
                id="address"
                type="text"
                label="Dirección"
                validators={[VALIDATOR_REQUIRE]}
                errorText="Por favor, introduce una dirección"
                onInput={inputHandler}
              />
            </React.Fragment>
          )}

        
          <Input
            id="email"
            element="input"
            type="email"
            label="E-mail"
            validators={[VALIDATOR_EMAIL()]}
            errorText="Please enter a valid Email"
            onInput={inputHandler}
          />
          <Input
            id="password"
            element="input"
            type="password"
            label="Password"
            validators={[VALIDATOR_MINLENGTH(6)]}
            errorText="Please enter a valid password, at least 6 characters ."
            onInput={inputHandler}
          />
          <Button type="submit" disabled={!formState.isValid}>
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
