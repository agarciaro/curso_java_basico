import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useHistory } from "react-router-dom";
import Button from "../../shared/components/FormElements/Button";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import { useHttpClient } from "../../shared/hooks/http-hook";
import Modal from "@mui/material/Modal";
import { DirectorItem } from "../components/DirectorItem";
import "./Pelicula.css";
import { ActorItem } from "../components/ActorItem";

function Pelicula() {
  const [loadedMovie, setLoadedMovie] = useState();
  const movieId = useParams().movieId;
  const { isLoading, error, sendRequest, clearError } = useHttpClient();
  const [loadedActors, setLoadedActors] = useState();
  const [loadedDirectors, setLoadedeDirectors] = useState();
  const [showActorModal, setShowActorModal] = useState(false);
  const [showDirectorModal, setShowDirectorModal] = useState(false);
  const [modalActorId, setModalActorId] = useState();
  const [modalDirectorId, setModalDirectorId] = useState();
  const history = useHistory();

  const openActorModalHandler = async (id) => {
    setModalActorId(id);
    setShowActorModal(true);
  };

  const openDirectorModalHandler = async (id) => {
    setModalDirectorId(id);
    setShowDirectorModal(true);
  };

  const closeActorModalHandler = () => {
    setShowActorModal(false);
  };
  const closeDirectorModalHandler = () => {
    setShowDirectorModal(false);
  };

  const closeDirectorModalHandlerRd = (id) => {
    setShowDirectorModal(false);
    history.push(`/movie/${id}`);
  };


  useEffect(() => {
    const fetchMovie = async () => {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/peliculas/${movieId}`
        );
        setLoadedMovie(responseData.pelicula);
        setLoadedActors(responseData.actores);
        setLoadedeDirectors(responseData.directores);
      } catch (err) {}
    };
    fetchMovie();
  }, [sendRequest, movieId]);

  return (
    <React.Fragment>
      <ErrorModal error={error} onClear={clearError} />
      {isLoading && (
        <div className="center">
          <LoadingSpinner />
        </div>
      )}
      {!isLoading && loadedMovie && loadedActors && loadedDirectors && (
        <>
          <Modal open={showActorModal} onClose={closeActorModalHandler}>
            <ActorItem
              actor={loadedActors.filter((actor) => actor.id === modalActorId)}
            ></ActorItem>
          </Modal>
          <Modal open={showDirectorModal} onClose={closeDirectorModalHandler}>
            <DirectorItem
              close={closeDirectorModalHandlerRd}
              director={loadedDirectors.filter(
                (director) => director.id === modalDirectorId
              )}
            ></DirectorItem>
          </Modal>
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
            <div className="movie_actor_director">
              <h2>Actores: </h2>
              <h3>
                {loadedActors.map((actor) => {
                  return (
                    <ul>
                      <li onClick={() => openActorModalHandler(actor.id)}>
                        {actor.nombre}
                      </li>
                    </ul>
                  );
                })}
              </h3>
              <h2>Directores: </h2>
              <h3>
                {loadedDirectors.map((director) => {
                  return (
                    <ul>
                      <li onClick={() => openDirectorModalHandler(director.id)}>
                        {director.nombre}
                      </li>
                    </ul>
                  );
                })}
              </h3>
            </div>
            <div className="movie_actions">
              <Button>Alquilar</Button>
            </div>
          </div>
        </>
      )}
      ;
    </React.Fragment>
  );
}

export default Pelicula;
