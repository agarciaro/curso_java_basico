import React from "react";
import Card from "../../shared/components/UIElements/Card";

import "./PeliculaItem.css";
import { Link } from "react-router-dom";

const PeliculaItem = (props) => {
  return (
    <React.Fragment>
      <li className="movie-item">
        <Link to={`movie/${props.id}`} style={{ textDecoration: 'none' }}>
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
            <div className="movie-item__actions"></div>
          </Card>
        </Link>
      </li>
    </React.Fragment>
  );
};

export default PeliculaItem;
