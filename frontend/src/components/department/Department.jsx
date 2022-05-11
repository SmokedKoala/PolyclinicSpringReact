import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";

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
      <div >
        <h1>Doctors</h1>
        <div>
          {doctors ?
              (
                  <div>
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
