import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Button from "../../shared/components/FormElements/Button";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import { useHttpClient } from "../../shared/hooks/http-hook";
import Modal from "@mui/material/Modal";
import "./Pelicula.css";
import { ActorItem } from "../components/ActorItem";

function Pelicula() {
  const [loadedMovie, setLoadedMovie] = useState();
  const movieId = useParams().movieId;
  const { isLoading, error, sendRequest, clearError } = useHttpClient();
  const [loadedActor, setLoadedActor] = useState("5");
  const [loadedDirector, setLoadedeDirector] = useState();
  const [showConfirmModal, setShowConfirmModal] = useState(true);

  const showStatusWarningHandler = (id) => {
    setShowConfirmModal(true);
  };
  const cancelDeleteHandler = () => {
    setShowConfirmModal(false);
  };

  useEffect(() => {
    const fetchMarkets = async () => {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/peliculas/${movieId}`
        );
        setLoadedMovie(responseData);
      } catch (err) {}
    };
    fetchMarkets();
  }, [sendRequest, movieId]);

  return (
    <React.Fragment>
      <ErrorModal error={error} onClear={clearError} />
      {isLoading && (
        <div className="center">
          <LoadingSpinner />
        </div>
      )}
      <Modal
        open={showConfirmModal}
        onClose={cancelDeleteHandler}
        className="ds-modal"
      >
        <ActorItem actor={loadedActor}></ActorItem>
      </Modal>
      {!isLoading && loadedMovie && (
        <div className="container">
          <div clasName="movie_img">
            <img
              className="imgf"
              src={
                loadedMovie.urlImagen
                  ? loadedMovie.urlImagen
                  : `https://www.sinrumbofijo.com/wp-content/uploads/2016/05/default-placeholder.png`
              }
              alt={loadedMovie.id}
            ></img>
          </div>
          <div className="movie_info">
            <h1> {loadedMovie.titulo}</h1>
            <h2>Sinopsis: </h2>
            <h3>{loadedMovie.sinopsis}</h3>
            <h2>Productora: </h2>
            <h3>{loadedMovie.productora}</h3>
            <h2>Pais de Producción: </h2>
            <h3>{loadedMovie.nacionalidad}</h3>
            <h2>Año de Estreno: </h2>
            <h3>{loadedMovie.fecha.slice(0, 4)}</h3>
          </div>
          <div className="movie_actions">
            <Button>Alquilar</Button>
          </div>
        </div>
      )}
      ;
    </React.Fragment>
  );
}

export default Pelicula;
