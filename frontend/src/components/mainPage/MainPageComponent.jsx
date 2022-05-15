import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import classes from './main_page.module.css'

function MainPageComponent() {
  const [departments, setDepartments] = useState(false);
  useEffect(() => {
    getDepartments();
  }, []);

  function getDepartments() {
    fetch('http://localhost:8080/departments')
    .then(async response => {
      return await response.json();
    })
    .then(data => {
      setDepartments(data);
    });
  }

  return (
      <div className={classes.AppMain}>
        <h3>Timetable</h3>
        <table id="appointment" className={classes.appointmentInfo}>
          <tbody>
          <tr>
            <td>Day of week</td>
            <td>Working hours</td>
          </tr>
          <tr>
            <td>Monday - Friday</td>
            <td>8:00 - 19:00</td>
          </tr>
          <tr>
            <td>Saturday - Sunday</td>
            <td>8:00 - 19:00</td>
          </tr>
          <tr>
            <td>Holidays</td>
            <td>8:00 - 19:00</td>
          </tr>
          </tbody>
        </table>


        <h3>Departments</h3>
        <div>
          {departments ?
              (
                  <div className={classes.appointmentInfo}>
                    {departments.map(department => (
                        <div>
                          <Link to = {`/departments/${department.departmentId}`}>{department.departmentName}</Link>
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

export default MainPageComponent;
