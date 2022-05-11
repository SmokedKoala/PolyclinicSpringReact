package ru.polyclinic.polyclinicspring.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Department;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.repositories.AppointmentRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AppointmentServiceImplTest {

  @Autowired
  private AppointmentService appointmentService;

  @MockBean
  private AppointmentRepository appointmentRepository;

  @Test
  void getSortedListOfFreeAppointments() {
//    Department department = new Department();
//    department.setDepartmentName("test");
//    Doctor doctor = new Doctor();
//    doctor.setDepartment(department);
//    Appointment appointment1 = new Appointment(1, new Timestamp(10000L), null, doctor, null);
//    Appointment appointment2 = new Appointment(2, new Timestamp(12300L), null, doctor, null);
//    Appointment appointment3 = new Appointment(3, new Timestamp(9999L), null, doctor, null);
//
//    List<Appointment> appointmentsToBe = new ArrayList<>();
//    appointmentsToBe.add(appointment3);
//    appointmentsToBe.add(appointment1);
//    appointmentsToBe.add(appointment2);
//
//    appointmentRepository.save(appointment1);
//    appointmentRepository.save(appointment2);
//    appointmentRepository.save(appointment3);
//
//    Mockito.doReturn(appointmentsToBe)
//        .when(appointmentRepository)
//        .findAll();
//
//    List<Appointment> appointments = appointmentService
//        .getSortedListOfFreeAppointments(doctor.getDepartment().getDepartmentName());
//    assertEquals(appointmentsToBe, appointments);
  }

  @Test
  void getSortedListOfAppointmentsForDoctor() {
  }

  @Test
  void getSortedListOfAppointmentsForPatient() {
  }
}