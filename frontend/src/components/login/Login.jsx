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
                <div className="alert alert-info">
                    <strong>Normal User</strong> - id: 2<br/>
                    <strong>Administrator</strong> - id: 1
                </div>

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
                                {isSubmitting &&
                                    <img
                                        src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
                                }
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
