package com.botscrew.university.service.executor;

import com.botscrew.university.dao.model.Department;
import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.model.University;
import com.botscrew.university.service.entity.DepartmentService;
import com.botscrew.university.service.entity.LectorService;
import com.botscrew.university.service.entity.UniversityService;
import org.springframework.stereotype.Service;

import static com.botscrew.university.config.TemplateConfig.DEPARTMENT_ARGUMENT;
import static com.botscrew.university.config.TemplateConfig.LECTOR_ARGUMENT;
import static com.botscrew.university.config.TemplateConfig.UNIVERSITY_ARGUMENT;

@Service
public class ListOfExecutor implements CommandExecutor {
  private final UniversityService universityService;
  private final DepartmentService departmentService;
  private final LectorService lectorService;

  public ListOfExecutor(UniversityService universityService,
      DepartmentService departmentService, LectorService lectorService) {
    this.universityService = universityService;
    this.departmentService = departmentService;
    this.lectorService = lectorService;
  }

  @Override public String execute(String arg) {
    StringBuilder result = new StringBuilder();
    if (arg.contains(UNIVERSITY_ARGUMENT)) {
      result.append("\nUniversities:");
      for (University e : universityService.list()) {
        result.append(String.format("\n\t%d: %s", e.getId(), e.getName()));
      }
    }
    if (arg.contains(DEPARTMENT_ARGUMENT)) {
      result.append("\nDepartments:");
      for (Department e : departmentService.list()) {
        result.append(String.format("\n\t%d: %s", e.getId(), e.getName()));
      }
    }
    if (arg.contains(LECTOR_ARGUMENT)) {
      result.append("\nLectors:");
      for (Lector e : lectorService.list()) {
        result.append(String.format("\n\t%d: %s %s %s, salary: %.2f, age: %d",
            e.getId(),e.getDegree().getName(), e.getFirstName(), e.getLastName(),e.getSalary(), e.getAge()));
      }
    }
    return result.toString();
  }
}
