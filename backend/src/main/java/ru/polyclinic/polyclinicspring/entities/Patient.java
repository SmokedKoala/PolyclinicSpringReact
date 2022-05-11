package ru.polyclinic.polyclinicspring.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient implements User{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  @OneToMany(targetEntity=Appointment.class, mappedBy = "patient", cascade = CascadeType.ALL)
  private List<Appointment> appointmentList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Appointment> getAppointmentList() {
    return appointmentList;
  }

  public void setAppointmentList(
      List<Appointment> appointmentList) {
    this.appointmentList = appointmentList;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
