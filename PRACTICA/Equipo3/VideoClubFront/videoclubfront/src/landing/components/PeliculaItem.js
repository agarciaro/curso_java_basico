import React from "react";
import Modal from "../../shared/components/UIElements/Modal";
import Button from "../../shared/components/FormElements/Button";
import Card from "../../shared/components/UIElements/Card";

import "./PeliculaItem.css";

const PeliculaItem = (props) => {
  return (
    <React.Fragment>
      <li className="movie-item">
        <Card className="movie-item__content">
          <div className="movie-item__image">
            <img
              src={`https://www.sinrumbofijo.com/wp-content/uploads/2016/05/default-placeholder.png`}
              alt={props.titulo}
            />
          </div>
          <div className="movie-item__info">
            <h2>{props.titulo}</h2>
            <p>{props.productora}</p>
          </div>
          <div className="movie-item__actions">
          </div>
        </Card>
      </li>
    </React.Fragment>
  );
};

export default PeliculaItem;
