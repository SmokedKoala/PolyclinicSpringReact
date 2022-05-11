package ru.polyclinic.polyclinicspring.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.polyclinic.polyclinicspring.entities.Patient;
import ru.polyclinic.polyclinicspring.repositories.PatientRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PatientServiceImplTest {

  @Autowired
  private PatientService userService;

  @MockBean
  private PatientRepository userRepository;

  @Test
  void findAllPatients() {
    Patient user1 = new Patient();
    Patient user2 = new Patient();
    Patient user3 = new Patient();
    List<Patient> usersToBeFound = new ArrayList<>();

    user1.setName("Ivanov Ivan Ivanovich");
    user1.setEmail("ivanov@mail.ru");
    user1.setPassword("qwerty");

    user2.setName("Petrov Petr Petrovich");
    user2.setEmail("petrov@mail.ru");
    user2.setPassword("123");

    userService.savePatient(user1);
    userService.savePatient(user2);
    userService.savePatient(user3);

    usersToBeFound.add(user1);
    usersToBeFound.add(user2);

    Mockito.doReturn(usersToBeFound)
        .when(userRepository)
        .findAll();

    assertEquals(usersToBeFound, userService.findAllPatients());
  }

  @Test
  void findByName() {
    Patient user = new Patient();
    user.setName("Ivanov Ivan Ivanovich");
    user.setEmail("ivanov@mail.ru");
    user.setPassword("qwerty");

    userService.savePatient(user);

    Mockito.doReturn(user)
        .when(userRepository)
        .findByName(user.getName());
  }

  @Test
  void saveUser() {
    Patient user = new Patient();
    user.setName("Ivanov Ivan Ivanovich");
    user.setEmail("ivanov@mail.ru");
    user.setPassword("qwerty");
    userService.savePatient(user);

    assertEquals("Ivanov Ivan Ivanovich", user.getName());
    Mockito.verify(userRepository, Mockito.times(1)).save(user);
  }

  @Test
  void deleteUser() {
    Patient user = new Patient();
    user.setName("Ivanov Ivan Ivanovich");
    user.setEmail("ivanov@mail.ru");
    user.setPassword("qwerty");
    user.setId(1);

    userService.savePatient(user);
    userService.deletePatient(1);

    verify(userRepository, times(1)).deleteById(1);
  }

  // TODO написать тест к updateUser
  @Test
  void updateUser() {
  }
}