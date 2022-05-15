import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import classes from './AppointmentList.module.css';

function AppointmentList() {
  const params = useParams();

  const [appointments, setAppointments] = useState(false);
  useEffect(() => {
    getAppointments();
  }, []);

  function getAppointments() {
    fetch('http://localhost:8080/appointments/'+params.appointment)
    .then(async response => {
      return await response.json();
    })
    .then(data => {
      console.log(data)
      setAppointments(data);
    });
  }

  return (
      <div  className={classes.AppMain}>
        <h3>Available Appointments</h3>
        <div>
          {appointments ?
              (
                  <div>
                    {appointments.map(appointment => (
                        <div className={classes.appointmentInfo}>
                          <p>{appointment.doctor.name}</p>
                          <p>Cabinet {appointment.doctor.cabinet}</p>
                          <p>{new Date(appointment.time).toLocaleString()}</p>
                          <button className={classes.updateButton}>Make an appointment</button>
                          <br/>
                        </div>
                    ))}
                  </div>
              ) : (
                  <p>There is no appointments data available</p>
              )
          }
        </div>
      </div>
  );
}

export default AppointmentList;
