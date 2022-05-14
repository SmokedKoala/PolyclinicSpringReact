package ru.polyclinic.polyclinicspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private Timestamp time;

  @Column(nullable = true)
  private String description;


  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }


  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor = new Doctor();


  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "patient_id")
  private Patient patient = new Patient();

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Appointment() {
  }

  public Appointment(Integer id, Timestamp time, String description,
      Doctor doctor, Patient patient) {
    this.id = id;
    this.time = time;
    this.description = description;
    this.doctor = doctor;
    this.patient = patient;
  }

  @Override
  public String toString() {
    return "Appointment{" +
        "id=" + id +
        ", time=" + time +
        ", doctor=" + doctor +
        ", patient=" + patient +
        '}';
  }
}
