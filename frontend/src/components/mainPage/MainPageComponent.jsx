import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

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
      <div>
        <h1>Timetable</h1>
        <table id="appointment">
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


        <h1>Departments</h1>
        <div>
          {departments ?
              (
                  <div>
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
