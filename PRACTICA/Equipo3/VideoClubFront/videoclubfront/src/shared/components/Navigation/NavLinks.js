import React, { useContext } from "react";
import { NavLink } from "react-router-dom";
import { AuthContext } from "../../context/auth-context";
import "./NavLinks.css";

const NavLinks = (props) => {
  const auth = useContext(AuthContext);

  return (
    <ul className="nav-links">
        <li>
       
        </li>
      {auth.isLoggedIn && (
        <li>
        </li>
      )}
      {!auth.isLoggedIn && (
        <li>
          <NavLink to="/auth/log" > Iniciar Sesión</NavLink>
        </li>
      )}
      {auth.isLoggedIn && (
        <li>
          <button className="batton" onClick={auth.logout}> Cerrar Sesión</button>
        </li>
      )}
    </ul>
  );
};

export default NavLinks;
