package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Department;
import com.botscrew.university.dao.model.Lector;

import java.util.List;

public interface DepartmentService {
  List<Department> list();

  List<Department> search(String arg);

  Department findByName(String name);

  List<Lector> getEmployers(String name);

  Integer getCountOfEmployers(String name);

  Double averageSalary(String name);

  void save(Department entity);

  void delete(Department entity);

  void update(Department entity);
}
