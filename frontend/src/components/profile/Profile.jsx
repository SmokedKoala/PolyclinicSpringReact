import patientLogo from "../../assets/img/patient.png";
import doctorLogo from "../../assets/img/doctor.png";
import classes from './Profile.module.css';
import {appointmentService} from "../../services/appointment.service";
import {useState} from "react";



function Profile() {

  const user = JSON.parse(localStorage.getItem('currentUser'))
  const role = localStorage.getItem('currentUserRole')
  let appointments = JSON.parse(localStorage.getItem('appointments'));
  let selected = "Therapy"

  function handleChange(e){
    selected = e.target.value
    console.log(selected)
  }

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
                  <form action={"/available/"+selected}>
                    <select
                        className={classes.select}
                        defaultValue={selected}
                        onChange={handleChange}
                        >
                      <option selected>Therapy</option>
                      <option>Surgery</option>
                      <option>Medical post</option>
                    </select>
                    <input className={classes.updateButton} type="submit" value="Search"/>
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
                                    <button className={classes.updateButton}>Change Description</button>
                                    <p>{appointment.patient.name}</p>
                                  </div>
                              )}
                              <p>{new Date(appointment.time).toLocaleString()}</p>

                              <p> Description: {appointment.description}</p>
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
