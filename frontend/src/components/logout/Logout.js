import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {authenticationService} from "../../services/authentication.service";
import React, {useState} from "react";
import axios from "axios";



function Logout(){
  authenticationService.logout();
  window.location.replace("/");
  return null;
}

export default Logout;