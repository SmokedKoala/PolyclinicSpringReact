import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import classes from "./Department.module.css"

function Department() {
  const params = useParams();

  const [doctors, setDoctors] = useState(false);
  useEffect(() => {
    getDoctors();
  }, []);

  function getDoctors() {
    fetch('http://localhost:8080/departments/'+params.id)
    .then(async response => {
      return await response.json();
    })
    .then(data => {
      setDoctors(data);
    });
  }

  return (
      <div className={classes.AppMain}>
        <h3>Doctors</h3>
        <div>
          {doctors ?
              (
                  <div className={classes.userInfo}>
                    {doctors.map(doctor => (
                        <div>
                          <p>{doctor.name}</p>
                          <p>Cabinet {doctor.cabinet}</p>
                          <p>{doctor.email}</p>
                          <br/>
                        </div>
                    ))}
                  </div>
              ) : (
                  <p>There is no departments data available</p>
              )
          }
        </div>
      </div>
  );
}

export default Department;
