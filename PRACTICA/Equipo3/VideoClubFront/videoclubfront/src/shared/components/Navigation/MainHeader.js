import React, { useEffect, useState } from "react";

import "./MainHeader.css";

const MainHeader = (props) => {
  const [navBar, setNavbar] = useState(false);
  const scrolling = (e) => {
    if (window.scrollY >= 30) {
      setNavbar(true);
    } else {
      setNavbar(false);
    }
  };

  useEffect(() => {
    scrolling();
    window.addEventListener("scroll", scrolling);
  });

  return (
    <header className={`main-header${(navBar && "n") || ""}`}>
      {props.children}
    </header>
  );
};

export default MainHeader;
