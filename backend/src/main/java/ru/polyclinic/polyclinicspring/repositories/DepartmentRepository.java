package ru.polyclinic.polyclinicspring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.polyclinic.polyclinicspring.entities.Department;

public interface DepartmentRepository  extends CrudRepository<Department, Integer> {
  Department findByDepartmentName(String name);

}
