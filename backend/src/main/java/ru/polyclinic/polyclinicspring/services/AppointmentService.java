package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.entities.Patient;

public interface AppointmentService {

  List<Appointment> getAllForDoctor(Doctor doctor);

  List<Appointment> getAllForPatient(Patient patient);

  void updateAppointment(Appointment appointment);

  List<Appointment> getSortedListOfFreeAppointments(String departmentName);

  List<Appointment> getSortedListOfAppointmentsForDoctor(int id);

  List<Appointment> getSortedListOfAppointmentsForPatient(int id);
}
