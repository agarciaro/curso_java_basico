import React from 'react';

import './LoadingSpinner.css';

const LoadingSpinner = props => {
  return (
    <div className={`${props.asOverlay && 'loading-spinner__overlay'}`}>
        <img className="lds-img" src={`${process.env.REACT_APP_BACKEND_IMG}/uploads/images/logo.png` }alt="logo" />
    </div>
  );
};

export default LoadingSpinner;
