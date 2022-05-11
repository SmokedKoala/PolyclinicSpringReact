package ru.polyclinic.polyclinicspring.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Department;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

  public Iterable<Appointment> findAppointmentsByDoctorIdAndPatientNotNull(int id);
  public Iterable<Appointment> findAppointmentsByPatientId(int id);
  public List<Appointment> findAppointmentsByPatientIsNullAndDoctor_Department_DepartmentName(String department);
}
