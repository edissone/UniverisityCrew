package com.botscrew.university.dao.repository;

import com.botscrew.university.dao.model.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends CrudRepository<University, Integer> {
  List<University> findAll();
  Optional<University> findByName(String name);
  Boolean existsByName(String name);
}
