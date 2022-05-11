package ru.polyclinic.polyclinicspring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ru.polyclinic.polyclinicspring.entities.Department;
import ru.polyclinic.polyclinicspring.repositories.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService{

  @Autowired
  DepartmentRepository departmentRepository;

  @Override
  public List<Department> getAllDepartments() {
    return (List<Department>) departmentRepository.findAll();
  }
}
