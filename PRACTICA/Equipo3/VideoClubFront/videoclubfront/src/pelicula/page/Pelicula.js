import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import { useHttpClient } from "../../shared/hooks/http-hook";
import "./Pelicula.css"

function Pelicula() {
  const [loadedMovie, setLoadedMovie] = useState();
  const movieId = useParams().movieId;
  const { isLoading, error, sendRequest, clearError } = useHttpClient();

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
      {!isLoading && loadedMovie && (
        <div className="container">
          <div clasName="movie_img">
            <img className="imgf" src={`https://www.sinrumbofijo.com/wp-content/uploads/2016/05/default-placeholder.png`}></img>
          </div>
          <div className="movie_info">
            <h1> {loadedMovie.titulo}</h1>
          </div>
          </div> 
      )}
      ;
    </React.Fragment>
  );


}

export default Pelicula;
