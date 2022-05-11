package ru.polyclinic.polyclinicspring.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.polyclinic.polyclinicspring.entities.Doctor;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.repositories.DoctorRepository;
import ru.polyclinic.polyclinicspring.repositories.PatientRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DoctorServiceImplTest {

  @Autowired
  private DoctorService doctorService;

  @MockBean
  private DoctorRepository doctorRepository;

  @Test
  void findAllDoctors() {
    Doctor user1 = new Doctor();
    Doctor user2 = new Doctor();
    Doctor user3 = new Doctor();
    List<Doctor> usersToBeFound = new ArrayList<>();

    user1.setName("Ivanov Ivan Ivanovich");
    user1.setEmail("ivanov@mail.ru");
    user1.setPassword("qwerty");

    user2.setName("Petrov Petr Petrovich");
    user2.setEmail("petrov@mail.ru");
    user2.setPassword("123");

    user3.setName("Sidorov Sergey Sergeevich");
    user3.setEmail("sidorov@mail.ru");
    user3.setPassword("11111");

    doctorService.saveDoctor(user1);
    doctorService.saveDoctor(user2);
    doctorService.saveDoctor(user3);

    usersToBeFound.add(user2);
    usersToBeFound.add(user3);

    Mockito.doReturn(usersToBeFound)
        .when(doctorRepository)
        .findAll();

    assertEquals(usersToBeFound, doctorService.findAllDoctors());
  }

}