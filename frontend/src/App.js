import './App.css';
import Header from "./components/header/Header";
import Footer from "./components/footer/Footer";
import MainPageRoutes from "./routes/MainPageRoutes";
import {isAuthenticated} from "./services/auth/auth";
import {Route, Routes} from "react-router-dom";
import React from "react";
import {authenticationService} from "./services/authentication.service";
import {Login} from "./components/login/Login";
import MainPageComponent from "./components/mainPage/MainPageComponent"
import Department from "./components/department/Department";

const user = {
    name: 'User',
    email: 'user@exmaple.com',
    roles: ['user']
};

const admin = {
    name: 'Admin',
    email: 'admin@exmaple.com',
    roles: ['user', 'admin']
};

// const currentUser = admin;

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            currentUser: null
        };
    }

    componentDidMount() {
        authenticationService.currentUser.subscribe(
            user => this.setState({
                    currentUser: user,
                }
            ));
    }

    render() {
        const {currentUser} = this.state;
        return (
            <div className="App">
                <Header user={currentUser}/>

                <main>
                    {
                        isAuthenticated(currentUser) && (
                            <MainPageRoutes user={currentUser}/>
                        )

                    }

                    <Routes>
                        <Route path='/departments/:id' element={<Department/>}/>
                        <Route exact path="/" element={<MainPageComponent/>}/>
                        <Route path="/login" element={<Login/>}/>
                    </Routes>
                </main>

                <Footer/>
            </div>
        );
    }
}

export default App;
