package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.model.University;
import com.botscrew.university.dao.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
  private final UniversityRepository repository;

  public UniversityServiceImpl(UniversityRepository repository) {
    this.repository = repository;
  }

  @Override public List<University> list() {
    return repository.findAll();
  }

  @Override public University findByName(String name) {
    return repository.findByName(name).orElseThrow(EntityNotFoundException::new);
  }

  @Override public void save(University entity) {
    repository.save(entity);
  }

  @Override public void delete(University entity) {

  }

  @Override public void update(University entity) {

  }
}
