package com.botscrew.university.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")
public class University {
  @Id
  @Column(name = "university_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(
      fetch = FetchType.LAZY,
      cascade = {
          CascadeType.REFRESH,
          CascadeType.REMOVE
      },
      orphanRemoval = true
  )
  @JoinTable(
      name = "university_to_department",
      joinColumns = @JoinColumn(name = "university_id"),
      inverseJoinColumns = @JoinColumn(name = "department_id")
  )
  private List<Department> departments;
}
