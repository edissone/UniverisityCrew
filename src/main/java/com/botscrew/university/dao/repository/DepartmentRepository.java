package com.botscrew.university.dao.repository;

import com.botscrew.university.dao.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
  Optional<Department> findByName(String name);

  @Query(nativeQuery = true,
      value = "select * from department " +
          "left join department_to_lector dtl on department.department_id = dtl.department_id " +
          "left join lector l on l.lector_id = dtl.lector_id " +
          "left join degree d on l.degree = d.degree_id " +
          "where department.name = ?1")
  Optional<Department> eagerFindByName(String name);

  @Query(nativeQuery = true, value = "select avg(salary) from department " +
      "left join department_to_lector dtl on department.department_id = dtl.department_id " +
      "left join lector l on l.lector_id = dtl.lector_id " +
      "where department.name = ?1")
  Double averageSalaryByDepartmentName(String name);

  @Query(nativeQuery = true, value = "select count(lector_id) from department_to_lector dtl " +
      "left join department d on dtl.department_id = d.department_id " +
      "where d.name = ?1")
  Integer countOfEmployers(String name);

  Boolean existsByName(String name);
}
