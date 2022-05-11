package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import ru.polyclinic.polyclinicspring.entities.Patient;


public interface PatientService {

  public List<Patient> findAllPatients();

  public Patient findByName(String name);

  public void savePatient(Patient user);

  public void deletePatient(Integer userId);

  public void updatePatient(Patient user);

//  TODO список записей и работа с ними
}
