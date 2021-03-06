package com.botscrew.university.dao.repository;

import com.botscrew.university.dao.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
  Optional<Department> findByName(String name);
  Boolean existsByName(String name);
}
