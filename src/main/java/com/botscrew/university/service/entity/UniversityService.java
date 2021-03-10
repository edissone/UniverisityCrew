package com.botscrew.university.service.entity;

import com.botscrew.university.dao.model.University;

import java.util.List;

public interface UniversityService {
  List<University> list();

  List<University> search(String arg);

  University findByName(String name);

  void save(University entity);

  void delete(University entity);

  void update(University entity);
}
