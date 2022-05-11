import logo from "../../assets/img/admin.png";
import classes from './Admin.module.css';

function Admin() {
    return (
        <div className={`${classes.AppMain}`}>
            <img src={logo} className={`${classes.logo}`} alt="logo"/>
            <p>
                I am <span>admin</span> and I can view <span>users</span>
            </p>
        </div>
    );
}

export default Admin;
