import React, { useEffect, useState } from "react";
import PeliculasList from "../components/PeliculasList";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import { useHttpClient } from "../../shared/hooks/http-hook";

const Landing = () =>{
    const [loadedMovies, setLoadedMovies] = useState();
    const { isLoading, error, sendRequest, clearError } = useHttpClient();
    const [ page , setPage] = useState(0);
    const [ size , setSize] = useState(8)

    useEffect(() => {
        const fetchMovies = async () => {
          
          try {
            const responseData = await sendRequest(
              `${process.env.REACT_APP_BACKEND_URL}/peliculas/?page=${page}&size=${size}`
            );
            setLoadedMovies(responseData.content);
          } catch (err) {}
        };
        fetchMovies();
      }, [sendRequest, page, size]);
    

      
  return (
    <React.Fragment>
      <ErrorModal error={error} onClear={clearError} />
      {isLoading && (
        <div className="center">
          <LoadingSpinner />
        </div>
      )}
      {!isLoading && loadedMovies && (
        <PeliculasList items={loadedMovies}  />
      )}
      ;
    </React.Fragment>
  );
};

export default Landing;