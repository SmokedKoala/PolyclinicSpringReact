import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {authenticationService} from "../../services/authentication.service";
import React, {useState} from "react";
import classes from './Login.module.css';
import axios from "axios";



function Login(){
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

// States for checking the errors
  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

// Handling the email change
  const handleEmail = (e) => {
    setEmail(e.target.value);
    setSubmitted(false);
  };

// Handling the password change
  const handlePassword = (e) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };

// Handling the form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (email === '' || password === '') {
      setError(true);
    } else {

      const params = {password: password, email: email};
      authenticationService.login(params.email, params.password).then(r => {
        if (r != null){
          window.location.replace("/");
        } else {
          <h2>Error occured</h2>
        }
      });
    }
  };

// Showing success message
  const successMessage = () => {
    return (
        <div
            className="success"
            style={{
              display: submitted ? '' : 'none',
            }}>
        </div>
    );
  };

// Showing error message if error is true
  const errorMessage = () => {
    return (
        <div
            className="error"
            style={{
              display: error ? '' : 'none',
            }}>
          <h1>Please enter all the fields</h1>
        </div>
    );
  };

  return (
      <div className="form">
        <div>
          <h1>Authorisation</h1>
        </div>

        {/* Calling to the methods */}
        <div className="messages">
          {errorMessage()}
          {successMessage()}
        </div>

        <form>
          <label className="label">Email</label>
          <input onChange={handleEmail} className="input"
                 value={email} type="email" />

          <label className="label">Password</label>
          <input onChange={handlePassword} className="input"
                 value={password} type="password" />

          <button onClick={handleSubmit} className="btn" type="submit">
            Submit
          </button>
        </form>
      </div>
  );
}

export default Login;