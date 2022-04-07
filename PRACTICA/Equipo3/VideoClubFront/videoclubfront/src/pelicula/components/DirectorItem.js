import React, { useState, useEffect } from "react";
import "./DirectorItem.css";
import { useHttpClient } from "../../shared/hooks/http-hook";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import { Link } from "react-router-dom";

export const DirectorItem = (props) => {
  const { isLoading, error, sendRequest, clearError } = useHttpClient();
  const [loadedMovies, setLoadedMovies] = useState();

  const handleDragStart = (e) => e.preventDefault();

  const responsive = {
    0: { items: 3 },
    568: { items: 2 },
    1024: { items: 3 },
  };

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const responseData = await sendRequest(
          `${process.env.REACT_APP_BACKEND_URL}/director/peliculas/?page=0&size=5&id=${props.director[0].id}`
        );
        setLoadedMovies(responseData.content);
      } catch (err) {}
    };
    fetchMovies();
  }, [sendRequest, props.director]);

  return (
    <div className="director_container">
      <div className="director_img">
        <img
          src={
            props.director[0].img
              ? props.director[0].img
              : "https://susanarocha.github.io//images/person.png"
          }
        ></img>
      </div>
      <div className="director_data">
        <h1>{props.director[0].nombre}</h1>
        <h2>Nacionalidad:</h2>
        <h3>{props.director[0].nacionalidad}</h3>
      </div>
      {!isLoading && loadedMovies && (
        <div className="carousel">
          <h2>Peliculas de {props.director[0].nombre}</h2>
          <AliceCarousel
            responsive={responsive}
            items={loadedMovies.map((movie) => {
              return (
                <Link to={`${movie.id}`} style={{ textDecoration: "none" }}   onClick={()=>props.close(movie.id)}>
                  <img
                    src={
                      movie.urlImagen
                        ? movie.urlImagen
                        : "https://www.sinrumbofijo.com/wp-content/uploads/2016/05/default-placeholder.png"
                    }
                    alt={movie.titulo}
                    onDragStart={handleDragStart}
                    role="presentation"
                  ></img>
                </Link>
              );
            })}
          />
        </div>
      )}
    </div>
  );
};
