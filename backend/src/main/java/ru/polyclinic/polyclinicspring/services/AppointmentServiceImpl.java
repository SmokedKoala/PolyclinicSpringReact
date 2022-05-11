package ru.polyclinic.polyclinicspring.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

  @Autowired
  AppointmentRepository appointmentRepository;

  @Override
  public List<Appointment> getAllForDoctor(Doctor doctor) {
    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
    return appointments.stream().filter(i -> i.getDoctor().equals(doctor)).collect(Collectors.toList());
  }

  @Override
  public List<Appointment> getAllForPatient(Patient patient) {
    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
    return appointments.stream().filter(i -> i.getPatient().equals(patient)).collect(Collectors.toList());
  }

  @Override
  public void updateAppointment(Appointment appointment) {
    Appointment appointment1 = appointmentRepository.findById(appointment.getId()).get();
    appointment1.setDescription(appointment.getDescription());
    appointment1.setPatient(appointment.getPatient());
    appointmentRepository.save(appointment1);
  }

  @Override
  public List<Appointment> getSortedListOfFreeAppointments(String departmentName) {
    List<Appointment> appointmentList = appointmentRepository
        .findAppointmentsByPatientIsNullAndDoctor_Department_DepartmentName(departmentName);
    appointmentList.stream().sorted(Comparator.comparing(Appointment::getTime))
        .collect(Collectors.toList());
    return appointmentList;
  }

  @Override
  public List<Appointment> getSortedListOfAppointmentsForDoctor(int id) {
    List<Appointment> appointmentList = (List<Appointment>) appointmentRepository
        .findAppointmentsByDoctorIdAndPatientNotNull(id);

    appointmentList.stream().sorted(Comparator.comparing(Appointment::getTime))
        .collect(Collectors.toList());
    return appointmentList;
  }

  @Override
  public List<Appointment> getSortedListOfAppointmentsForPatient(int id) {
    List<Appointment> appointmentList= (List<Appointment>) appointmentRepository
        .findAppointmentsByPatientId(
            id);
    appointmentList.stream().sorted(Comparator.comparing(Appointment::getTime))
        .collect(Collectors.toList());
    return appointmentList;
  }
}
