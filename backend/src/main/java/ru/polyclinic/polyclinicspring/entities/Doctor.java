package ru.polyclinic.polyclinicspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor implements User{

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  @Column(nullable = true)
  private int cabinet;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "department_id")
  private Department department = new Department();

  @JsonIgnore
  @OneToMany(targetEntity=Appointment.class, mappedBy = "doctor", cascade = CascadeType.ALL)
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<Appointment> getAppointmentList() {
    return appointmentList;
  }

  public void setAppointmentList(
      List<Appointment> appointmentList) {
    this.appointmentList = appointmentList;
  }

  public int getCabinet() {
    return cabinet;
  }

  public void setCabinet(int cabinet) {
    this.cabinet = cabinet;
  }

  public Doctor() {
  }

  public Doctor(Integer id, String name, String password, String email, int cabinet,
      Department department) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.cabinet = cabinet;
    this.department = department;
  }

  @Override
  public String toString() {
    return "Doctor{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}


