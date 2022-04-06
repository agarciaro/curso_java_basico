import React, { useState } from "react";

const SortButton = () => {
  const [asc, setAsc] = useState(false);
  const [desc, setDesc] = useState(false);
  const [noDir, setNoDir] = useState(true);
  
  return (
    <div>
      <button
        className="sortButton"
        onClick={props.onClick}
        disabled={props.disabled}
        value={props.value}
      ></button>
    </div>
  );
};

export default SortButton;
