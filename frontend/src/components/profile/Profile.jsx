import patientLogo from "../../assets/img/patient.png";
import doctorLogo from "../../assets/img/doctor.png";
import classes from './Profile.module.css';
import {appointmentService} from "../../services/appointment.service";
import {useState} from "react";



function Profile() {

  function handleChange(e){
    e.preventDefault();
    window.location.replace("/available/"+e.target.value);
  }

  const user = JSON.parse(localStorage.getItem('currentUser'))
  const role = localStorage.getItem('currentUserRole')
  let appointments = JSON.parse(localStorage.getItem('appointments'));

  console.log(user)
  console.log(role)
  console.log(appointments)

  return (
      <div className={`${classes.AppMain}`}>
        <div className={`${classes.MainInfo}`}>
          <div>
            <h3>My profile</h3>
            {role === 'patient' ? (
                <img src={patientLogo} className={`${classes.logo}`}
                     alt="logo"/>
            ) : (
                <img src={doctorLogo} className={`${classes.logo}`} alt="logo"/>
            )}
            <div className={classes.userInfo}>
              <p>Name: {user.name}</p>
              <p>Email: {user.email}</p>
            </div>
            {role === 'patient' ? (
                <div>
                  <h3>New Appointment</h3>
                  <form>
                    <select
                        onSubmit={e => handleChange(e)}>
                      <option>Therapy</option>
                      <option>Surgery</option>
                      <option>Medical post</option>
                    </select>
                    <input type="submit" value="Search"/>
                  </form>
                </div>
            ) : (
                <div/>
            )}
          </div>
          <div>
            <h3>Appointments</h3>
            <div>
              {appointments ?
                  (
                      <div>
                        {appointments.map(appointment => (
                            <div className={classes.userInfo}>
                              {role === 'patient' ? (
                                  <div>
                                    <p>{appointment.doctor.name}</p>
                                    <p>cabinet {appointment.doctor.cabinet}</p>
                                  </div>
                              ) : (
                                  <div>
                                    <p>{appointment.patient.name}</p>
                                  </div>
                              )}
                              <p>{appointment.time}</p>
                              <p>{appointment.description}</p>
                            </div>
                        ))}
                      </div>
                  ) : (
                      <p>There is no departments data available</p>
                  )
              }
            </div>
          </div>
        </div>
      </div>
  );
}

export default Profile;
