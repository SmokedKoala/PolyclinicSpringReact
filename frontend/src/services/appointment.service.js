import {handleResponse} from "../helpers";
import {useState} from "react";

export const appointmentService = {
  GetAppointmentInfoForPatient,
  GetAppointmentInfoForDoctor,
  GetAppointmentsListForPatient,
  GetAppointmentsListForDoctor,
  logout
};
function GetAppointmentsListForPatient(id) {
  const [list, setList] = useState(false);
  fetch('http://localhost:8080/appointments/patient/'+id)
  .then(async response => {
    return await response.json();
  })
  .then(data => {
    console.log(data);
    setList(data);
  });
  console.log(list)
  return list;
}

function GetAppointmentsListForDoctor(id) {
  const [list, setList] = useState(false);
  fetch('http://localhost:8080/appointments/doctor/'+id)
  .then(async response => {
    return await response.json();
  })
  .then(data => {
    console.log(data);
    setList(data);
  });
  return list;
}


function GetAppointmentInfoForPatient(id) {
  const [doctor, setDoctor] = useState(false);
  fetch('http://localhost:8080/appointments/patient/info/'+id)
  .then(async response => {
    return await response.json();
  })
  .then(data => {
    console.log(data);
    setDoctor(data)
  });
  return doctor;
}

function GetAppointmentInfoForDoctor(id) {
  const [patient, setPatient] = useState(false);
  fetch('http://localhost:8080/appointments/doctor/info/'+id)
  .then(async response => {
    return await response.json();
  })
  .then(data => {
    console.log(data);
    setPatient(data)
  });
  return patient;
}

function logout() {

}