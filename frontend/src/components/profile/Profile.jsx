import logo from "../../assets/img/user.png";
import classes from './Profile.module.css';
import {useEffect, useState} from "react";

function Profile(props) {
    const [user, setUser] = useState(false);

    useEffect(() => {
        getUser(props.user.id);
    }, []);

    function getUser(id) {
        fetch(`http://localhost:3001/users/${id}`)
            .then(async response => {
                return await response.json();
            })
            .then(data => {
                setUser(data);
            });
    }

    function updateUser(id) {
        let name = prompt('Enter user name');
        let email = prompt('Enter user email');

        fetch(`http://localhost:3001/users/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, email}),
        })
            .then(response => {
                return response.text();
            })
            .then(data => {
                alert(data);
                getUser(id);
            });
    }

    return (
        <div className={`${classes.AppMain}`}>
            <img src={logo} className={`${classes.logo}`} alt="logo"/>
            <h3>My profile</h3>
            <div className={classes.userInfo}>
                <p>Name: {user.name}</p>
                <p>Email: {user.email}</p>
            </div>
            {user && <button onClick={() => updateUser(user.id)} className={classes.updateButton}>Update info</button>}
        </div>
    );
}

export default Profile;
