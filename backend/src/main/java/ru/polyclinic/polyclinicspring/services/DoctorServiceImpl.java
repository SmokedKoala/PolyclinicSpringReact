package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  DoctorRepository doctorRepository;

  @Override
  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  @Override
  public List<Doctor> findBySpeciality(int speciality) {
    return  doctorRepository.findDoctorByDepartmentDepartmentId(speciality);
//    return all.stream().filter(i-> i.getDepartment().getDepartmentId().equals(speciality)).collect(Collectors.toList());
  }

  @Override
  public void saveDoctor(Doctor user) {
    doctorRepository.save(user);
  }

  @Override
  public void deleteDoctor(Integer userId) {
  doctorRepository.deleteById(userId);
  }

  @Override
  public void updateDoctor(Doctor user) {
    List<Appointment> appointmentList1 = user.getAppointmentList();
    List<Appointment> appointmentList = doctorRepository.findById(user.getId()).get()
        .getAppointmentList();
    appointmentList1.addAll(appointmentList);
    user.setAppointmentList(appointmentList1);
  }

  @Override
  public Doctor findByName(String name) {
    return doctorRepository.findByName(name);
  }
}
