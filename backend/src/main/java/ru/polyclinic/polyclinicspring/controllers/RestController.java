package ru.polyclinic.polyclinicspring.controllers;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.polyclinic.polyclinicspring.entities.Appointment;
import ru.polyclinic.polyclinicspring.entities.Department;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.entities.User;
import ru.polyclinic.polyclinicspring.repositories.AppointmentRepository;
import ru.polyclinic.polyclinicspring.repositories.DepartmentRepository;
import ru.polyclinic.polyclinicspring.repositories.DoctorRepository;
import ru.polyclinic.polyclinicspring.repositories.PatientRepository;
import ru.polyclinic.polyclinicspring.services.AppointmentService;
import ru.polyclinic.polyclinicspring.services.DoctorService;
import ru.polyclinic.polyclinicspring.services.PatientService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  DoctorService doctorService;

  @Autowired
  PatientService patientService;

  @Autowired
  AppointmentService appointmentService;


  @GetMapping(path = "/departments")
  public @ResponseBody
  Iterable<Department> getAllDepartments () {
    return departmentRepository.findAll();
  }

  @GetMapping(path = "/departments/{department}")
  public @ResponseBody
  Iterable<Doctor> getDoctorsByDepartment (@PathVariable("department") int department) {
    return doctorService.findBySpeciality(department);
  }

  @GetMapping(path = "/appointments/patient/{id}")
  public Iterable<Appointment> getAppointmentsForPatient(@PathVariable("id") int id){
    return appointmentService.getSortedListOfAppointmentsForPatient(id);
  }

  @GetMapping(path = "/appointments/patient/info/{id}")
  public Doctor getAppointmentInfoForPatient(@PathVariable("id") int id){
    Appointment appointment = appointmentRepository.findById(id).get();
    return appointment.getDoctor();
  }

  @GetMapping(path = "/appointments/doctor/{id}")
  public Iterable<Appointment> getAppointmentsForDoctor(@PathVariable("id") int id){
    return appointmentService.getSortedListOfAppointmentsForDoctor(id);
  }

  @GetMapping(path = "/appointments/doctor/info/{id}")
  public String getAppointmentInfoForDoctor(@PathVariable("id") int id) {
    Appointment appointment = appointmentRepository.findById(id).get();
    return appointment.getPatient().getName();
  }

  @GetMapping(path = "/appointments/{department}")
  public Iterable<Appointment> getAvailableAppointments(@PathVariable("department") String department){
    return appointmentService.getSortedListOfFreeAppointments(department);
  }

  @GetMapping(path = "/patients/{email}")
  public Patient getPatientByEmail(@PathVariable("email") String email){
    return patientRepository.findByEmail(email);
  }

  @GetMapping(path = "/doctors/{email}")
  public Doctor getDoctorByEmail(@PathVariable("email") String email){
    return doctorRepository.findByEmail(email);
  }

  @PostMapping(path = "/patients")
  Patient signUp (@RequestBody Patient patient){
    return patientRepository.save(patient);
  }

  @PostMapping(path = "/auth")
  User logIn (@RequestBody Patient recieved){
    User user;
    user = patientRepository.findByEmailAndPassword(recieved.getEmail(), recieved.getPassword());
    if (user == null)
      user = doctorRepository.findByEmailAndPassword(recieved.getEmail(), recieved.getPassword());
    System.out.println(user);
    return user;
  }
}
