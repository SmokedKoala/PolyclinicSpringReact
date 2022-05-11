package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  PatientRepository patientRepository;

  @Override
  public List<Patient> findAllPatients() {
    return (List<Patient>) patientRepository.findAll();
  }

  @Override
  public Patient findByName(String name) {
    return patientRepository.findByName(name);
  }

  @Override
  public void savePatient(Patient user) {
  patientRepository.save(user);
  }

  @Override
  public void deletePatient(Integer userId) {
    patientRepository.deleteById(userId);
  }

  @Override
  public void updatePatient(Patient user) {
    List<Appointment> appointmentList1 = user.getAppointmentList();
    List<Appointment> appointmentList = patientRepository.findById(user.getId()).get()
        .getAppointmentList();
    appointmentList1.addAll(appointmentList);
    user.setAppointmentList(appointmentList1);
    patientRepository.save(user);
  }
}
