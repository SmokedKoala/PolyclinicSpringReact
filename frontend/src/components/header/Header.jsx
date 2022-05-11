import classes from "./Header.module.css";
import {Link} from "react-router-dom";
import {hasRole, isAuthenticated} from "../../services/auth/auth";

function Header({user}) {
    return (
        <div className={`${classes.header}`}>
            <Link to="/" className={`${classes.logo}`}>Polyclinic</Link>
            <div className={`${classes.links}`}>
                <Link to="/" className={`${classes.link}`}>Home</Link>
                {isAuthenticated(user) && <Link to="profile" className={`${classes.link}`}>Profile</Link>}
                {!isAuthenticated(user) && <Link to="login" className={`${classes.link}`}>Log In</Link>}
                {!isAuthenticated(user) && <Link to="signup" className={`${classes.link}`}>Sign up</Link>}
            </div>
        </div>
    );
}

export default Header;
