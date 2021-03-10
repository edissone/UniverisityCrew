package com.botscrew.university.dao.model;

import com.botscrew.university.service.ids.Describable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "department")
public class Department extends Describable {
  @Id
  @Column(name = "department_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToOne(cascade = { CascadeType.PERSIST })
  @JoinColumn(name = "head", referencedColumnName = "lector_id")
  private Lector head;

  @ManyToMany()
  @JoinTable(
      name = "department_to_lector",
      joinColumns = @JoinColumn(name = "department_id"),
      inverseJoinColumns = @JoinColumn(name = "lector_id")
  )
  private List<Lector> lectors;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "university", referencedColumnName = "university_id")
  private University university;

  @Override public String desc() {
    return String.format("%s: University: %s", name, university.getName());
  }
}
