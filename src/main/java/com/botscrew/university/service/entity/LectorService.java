package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Lector;

import java.util.List;

public interface LectorService {
  List<Lector> list();

  Lector findByName(String firstName, String lastName);

  void save(Lector entity);

  void delete(Lector entity);

  void update(Lector entity);
}
