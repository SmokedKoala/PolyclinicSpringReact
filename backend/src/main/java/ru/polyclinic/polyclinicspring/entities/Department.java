package ru.polyclinic.polyclinicspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer departmentId;

  @Column(nullable = false)
  private String departmentName;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
  private List<Doctor> doctorList;

  public void setDoctorList(
      Collection<Doctor> doctorList) {
    this.doctorList = (List<Doctor>) doctorList;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public List<Doctor> getDoctorList() {
    return doctorList;
  }

  public void setDoctorList(List<Doctor> doctorList) {
    this.doctorList = doctorList;
  }

  public Department() {
  }

  public Department(Integer departmentId, String departmentName,
      List<Doctor> doctorList) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.doctorList = doctorList;
  }

  @Override
  public String toString() {
    return "Department{" +
        "departmentId=" + departmentId +
        ", departmentName='" + departmentName + '\'' +
        ", doctorList=" + doctorList +
        '}';
  }
}
