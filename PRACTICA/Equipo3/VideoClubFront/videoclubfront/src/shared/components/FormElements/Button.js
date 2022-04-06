import React from "react";
import { Link } from "react-router-dom";

import "./Button.css";

const Button = (props) => {
  if (props.href) {
    return (
      <a
        className={`button button--${props.size || "default"} ${
          props.inverse && "button--inverse"
        } ${props.danger && "button--danger"}`}
        href={props.href}
      >
        {props.children}
      </a>
    );
  }
  if (props.to) {
    return (
      <Link
        to={props.to}
        exact={props.exact}
        className={`${
          props.dClassName || `button button--${props.size || "default"}`
        } ${props.inverse && "button--inverse"} ${
          props.danger && "button--danger"
        }`}
      >
        {props.children}
      </Link>
    );
  }
  return (
    <button
      className={`${
        props.dClassName || `button button--${props.size || "default"}`
      } ${props.inverse && "button--inverse"} ${
        props.danger && "button--danger"
      }`}
      type={props.type}
      onClick={props.onClick}
      disabled={props.disabled}
      value={props.value}
    >
      {props.children}
    </button>
  );
};

export default Button;
