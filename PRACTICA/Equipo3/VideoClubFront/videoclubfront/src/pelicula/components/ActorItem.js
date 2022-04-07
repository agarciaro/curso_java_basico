import React, { useState, useEffect } from "react";
import "./ActorItem.css";
import { useHttpClient } from "../../shared/hooks/http-hook";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

export const ActorItem = (props) => {
  const { isLoading, error, sendRequest, clearError } = useHttpClient();
  const [loadedMovies, setLoadedMovies] = useState();

  const handleDragStart = (e) => e.preventDefault()

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/actor/peliculas/?page=0&size=5&id=${props.actor[0].id}`
        );
        setLoadedMovies(responseData.content);
      } catch (err) {}
    };
    fetchMovies();
  }, [sendRequest, props.actor]);

  return (
    <div className="actor_container">
      <div className="actor_img">
        <img
          src={
            props.actor[0].img
              ? props.actor[0].img
              : "https://susanarocha.github.io//images/person.png"
          }
        ></img>
      </div>
      <div className="actor_data">
        <h1>{props.actor[0].nombre}</h1>
        <h2>Nacionalidad:</h2>
        <h3>{props.actor[0].nacionalidad}</h3>
        <h2>Genero:</h2>
        <h3>{props.actor[0].sexo}</h3>
      </div>
      {!isLoading && loadedMovies && (
        <div className="carousel">
          <AliceCarousel
            mouseTracking
            items={loadedMovies.map((movie) => {
              return (
                <img
                  src={
                    movie.img
                      ? movie.img
                      : "https://www.sinrumbofijo.com/wp-content/uploads/2016/05/default-placeholder.png"
                  }
                  onDragStart={handleDragStart}
                  role="presentation"
                ></img>
              );
            })}
          />
        </div>
      )}
    </div>
  );
};
