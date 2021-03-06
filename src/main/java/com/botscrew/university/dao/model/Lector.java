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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lector")
public class Lector {
  @Id
  @Column(name = "lector_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "firstname", nullable = false)
  private String firstName;

  @Column(name = "lastname", nullable = false)
  private String lastName;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "salary")
  private Double salary;

  @OneToOne(mappedBy = "head")
  private Department headOf;

  @ManyToOne(
      cascade = {
          CascadeType.REFRESH
      }
  )
  @JoinColumn(name = "degree")
  private Degree degree;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.MERGE,
          CascadeType.REFRESH
      },
      mappedBy = "lectors")
  private List<Department> departments;

}
