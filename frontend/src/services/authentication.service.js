import { BehaviorSubject } from 'rxjs';

import { handleResponse } from '../helpers';
import {appointmentService} from "./appointment.service";
import {useState} from "react";

const currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));

export const authenticationService = {
    Login,
    logout,
    currentUser: currentUserSubject.asObservable(),
    get currentUserValue () { return currentUserSubject.value }
};

function Login(email, password) {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({email, password})
    };
    console.log(requestOptions);
    return fetch(`http://localhost:8080/auth`, requestOptions)
        .then(handleResponse)
        .then(user => {
            localStorage.setItem('currentUser', JSON.stringify(user));
            currentUserSubject.next(user);

            if (typeof user.cabinet === 'undefined'){
                localStorage.setItem('currentUserRole', "patient");
                fetch('http://localhost:8080/appointments/patient/'+user.id)
                .then(async response => {
                    return await response.json();
                })
                .then(data => {
                    console.log(data);
                    localStorage.setItem('appointments', JSON.stringify(data));
                });
            } else {
                localStorage.setItem('currentUserRole', "doctor");
                fetch('http://localhost:8080/appointments/doctor/'+user.id)
                .then(async response => {
                    return await response.json();
                })
                .then(data => {
                    console.log(data);
                    localStorage.setItem('appointments', JSON.stringify(data));
                });
            }
            return user;
        });
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    currentUserSubject.next(null);
}
