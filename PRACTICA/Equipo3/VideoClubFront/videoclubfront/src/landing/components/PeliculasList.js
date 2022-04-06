import React from "react";

import PeliculaItem from "./PeliculaItem";
import Card from "../../shared/components/UIElements/Card";
import "./PeliculaList.css"

const PeliculasList = (props) => {
  if (props.items.length === 0) {
    return (
      <div className="center">
        <Card>
        <h2> No se han encontrado Peliculas</h2>
        </Card>
      </div>
    );
  }
  return (
    <div >
  <ul className="movie-list">
    {props.items.map((movie) => {
      return (
        <PeliculaItem
          key={movie.id}
          id={movie.id}
          titulo={movie.titulo}
          nacionalidad={movie.nacionalidad}
          productora={movie.productora}
          fecha={movie.fecha}
          url={movie.url}
          
        />
      );
    })}
  </ul>
  </div>
);
};

export default PeliculasList;
