package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Department;
import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.repository.DepartmentRepository;
import com.botscrew.university.dao.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {
  private final LectorRepository repository;

  @Autowired
  public LectorServiceImpl(LectorRepository repository) {
    this.repository = repository;
  }

  @Override public List<Lector> list() {
    return repository.findAll();
  }

  @Override public Lector findByName(String firstName, String lastName) {
    return repository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(EntityNotFoundException::new);
  }

  @Override public void save(Lector entity) {
    repository.save(entity);
  }

  @Override public void delete(Lector entity) {
    if (repository.existsByFirstNameAndLastName(entity.getFirstName(), entity.getLastName()))
      repository.delete(entity);
  }

  @Override public void update(Lector entity) {
    if (repository.existsByFirstNameAndLastName(entity.getFirstName(), entity.getLastName()))
      repository.save(entity);
  }
}
