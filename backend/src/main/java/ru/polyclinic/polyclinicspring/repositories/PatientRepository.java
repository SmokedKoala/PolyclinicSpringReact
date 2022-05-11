package ru.polyclinic.polyclinicspring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.polyclinic.polyclinicspring.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
  Patient findByName(String name);
  Patient findByEmail(String email);
}
