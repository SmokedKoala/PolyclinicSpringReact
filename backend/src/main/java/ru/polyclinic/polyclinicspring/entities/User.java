package ru.polyclinic.polyclinicspring.entities;

import java.util.List;

public interface User {

  public Integer getId();

  public void setId(Integer id);

  public String getName();

  public void setName(String name);

  public String getEmail();

  public void setEmail(String email);

  public String getPassword();

  public void setPassword(String password);

  public List<Appointment> getAppointmentList();
}
