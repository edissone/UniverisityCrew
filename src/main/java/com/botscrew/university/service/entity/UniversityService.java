package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.model.University;

import java.util.List;

public interface UniversityService {
  List<University> list();
  University findByName(String name);

  void save(University entity);
  void delete(University entity);
  void update(University entity);
}
