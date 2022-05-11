import logo from "../../assets/img/user.png";
import classes from './User.module.css';

function User() {
    return (
        <div className={`${classes.AppMain}`}>
            <img src={logo} className={`${classes.logo}`} alt="logo"/>
            <p>
                I am <span>user</span> and I can view <span>articles</span>
            </p>
        </div>
    );
}

export default User;
