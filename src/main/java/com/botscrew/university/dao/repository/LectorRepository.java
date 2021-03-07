package com.botscrew.university.dao.repository;

import com.botscrew.university.dao.model.Lector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LectorRepository extends CrudRepository<Lector, Integer> {
  List<Lector> findAll();
  Optional<Lector> findByFirstNameAndLastName(String first, String last);
  Boolean existsByFirstNameAndLastName(String first, String last);
}
