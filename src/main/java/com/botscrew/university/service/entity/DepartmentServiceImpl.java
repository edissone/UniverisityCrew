package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Department;
import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  private final DepartmentRepository repository;

  @Autowired
  public DepartmentServiceImpl(DepartmentRepository repository) {
    this.repository = repository;
  }

  @Override public List<Department> list() {
    return (List<Department>) repository.findAll();
  }

  @Override public Department findByName(String name) {
    return repository.findByName(name).orElseThrow(EntityNotFoundException::new);
  }

  @Override public Double averageSalary(String name) {
    return repository.averageSalaryByDepartmentName(name);
  }

  @Transactional
  @Override public List<Lector> getEmployers(String name) {
    Department department = repository.eagerFindByName(name).orElseThrow(EntityNotFoundException::new);
    return department.getLectors().stream().sorted(Comparator.comparing(lector -> lector.getDegree().getId())).collect(
        Collectors.toList());
  }

  @Override public Integer getCountOfEmployers(String name) {
    return repository.countOfEmployers(name);
  }

  @Override public void save(Department entity) {
    repository.save(entity);
  }

  @Override public void delete(Department entity) {
    if (repository.existsByName(entity.getName()))
      repository.delete(entity);
  }

  @Override public void update(Department entity) {
    if (repository.existsByName(entity.getName()))
      repository.save(entity);
  }
}
