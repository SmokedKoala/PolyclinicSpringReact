import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {authenticationService} from "../../services/authentication.service";
import React from "react";
import classes from './Login.module.css';


class Login extends React.Component {
    constructor(props) {
        super(props);

        // redirect to home if already logged in
        if (authenticationService.currentUserValue) {
            this.props.history.push('/');
        }
    }

    render() {
        return (
            <div>

                <h2>Login</h2>

                <Formik
                    initialValues={{
                        id: ''
                    }}
                    validationSchema={Yup.object().shape({
                        id: Yup.string().required('ID is required')
                    })}
                    onSubmit={({id}, {setStatus, setSubmitting}) => {
                        setStatus();
                        authenticationService.login(id)
                            .then(
                                user => {
                                    const {from} = this.props.location.state || {from: {pathname: "/"}};
                                    this.props.history.push(from);
                                },
                                error => {
                                    setSubmitting(false);
                                    setStatus(error);
                                }
                            );
                    }}
                    render={({errors, status, touched, isSubmitting}) => (
                        <Form>
                            <div className="form-group">
                                <label htmlFor="id">ID</label>
                                <Field name="id" type="text"
                                       className={'form-control' + (errors.id && touched.id ? ' is-invalid' : '')}/>
                                <ErrorMessage name="id" component="div" className="invalid-feedback"/>
                            </div>
                            <div className="form-group">
                                <button type="submit" className={classes.loginButton} disabled={isSubmitting}>Login</button>
                            </div>
                            {status &&
                                <div className={'alert alert-danger'}>{status}</div>
                            }
                        </Form>
                    )}
                />
            </div>
        );
    }

}

export {Login};
