import React from "react";
import classes from "./Footer.module.css"

function Footer() {
    return (
        <div className={`${classes.footer}`}>
            <i className={`fa fa-facebook ${classes.socialIcon}`}></i>
            <i className={`fa fa-twitter ${classes.socialIcon}`}></i>
            <i className={`fa fa-instagram ${classes.socialIcon}`}></i>
            <i className={`fa fa-github ${classes.socialIcon}`}></i>
        </div>
    );
}

export default Footer;
