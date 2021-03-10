package com.botscrew.university.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "degree")
public class Degree {
  @Id
  @Column(name = "degree_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(
      fetch = FetchType.LAZY,
      cascade = {
          CascadeType.REFRESH
      },
      orphanRemoval = true,
      mappedBy = "degree"
  )
  private List<Lector> lectors;

  @Override public String toString() {
    return name;
  }
}
