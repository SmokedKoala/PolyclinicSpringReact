package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import ru.polyclinic.polyclinicspring.entities.Doctor;

public interface DoctorService {

  public List<Doctor> findAllDoctors();

  public Iterable<Doctor> findBySpeciality(int speciality);

  public void saveDoctor(Doctor user);

  public void deleteDoctor(Integer userId);

  public void updateDoctor(Doctor user);

  public Doctor findByName(String name);
}
