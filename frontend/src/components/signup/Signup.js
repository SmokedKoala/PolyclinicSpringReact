import {useState} from "react";

const axios = require("axios");

function Signup(){
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

// States for checking the errors
  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

// Handling the name change
  const handleName = (e) => {
    setName(e.target.value);
    setSubmitted(false);
  };

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
    if (name === '' || email === '' || password === '') {
      setError(true);
    } else {

      const params = {name: name, password: password, email: email};
      axios
      .post("http://localhost:8080/patients", params)
      .then(resp => {
        if (resp.status === 200)
          setSubmitted(true);
          setError(false);
      })
      .catch(err => {
        console.log("Sign up data submit error: ", err);
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
          <h1>User {name} successfully registered!!</h1>
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
          <h1>Patient Registration</h1>
        </div>

        {/* Calling to the methods */}
        <div className="messages">
          {errorMessage()}
          {successMessage()}
        </div>

        <form>
          {/* Labels and inputs for form data */}
          <label className="label">Name</label>
          <input onChange={handleName} className="input"
                 value={name} type="text" />

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

export default Signup;