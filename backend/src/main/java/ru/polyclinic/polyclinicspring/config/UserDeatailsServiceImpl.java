package ru.polyclinic.polyclinicspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.polyclinic.polyclinicspring.entities.User;
import ru.polyclinic.polyclinicspring.repositories.DoctorRepository;
import ru.polyclinic.polyclinicspring.repositories.PatientRepository;

@Service
public class UserDeatailsServiceImpl implements UserDetailsService {

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  DoctorRepository doctorRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user;
    user = patientRepository.findByEmail(s);
    if (user == null)
      user = doctorRepository.findByEmail(s);

    System.out.println(user.toString());

    return new UserDetailsImpl(user);
  }
}
