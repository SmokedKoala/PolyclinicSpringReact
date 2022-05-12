package ru.polyclinic.polyclinicspring.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ru.polyclinic.polyclinicspring.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
  Doctor findByName(String name);
  Doctor findByEmail(String email);
  Doctor findByEmailAndPassword(String email, String password);

  List<Doctor> findDoctorByDepartmentDepartmentId(int speciality);

}
