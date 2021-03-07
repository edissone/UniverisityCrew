package com.botscrew.university.service.executor;

import com.botscrew.university.dao.model.Degree;
import com.botscrew.university.dao.model.Lector;
import com.botscrew.university.dao.repository.DegreeRepository;
import com.botscrew.university.service.util.ArgumentProcessor;
import com.botscrew.university.service.entity.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.util.List;

@Service
public class StatisticExecutor implements CommandExecutor {
  private final DepartmentService departmentService;
  private final DegreeRepository degreeRepository;

  @Autowired
  public StatisticExecutor(DepartmentService departmentService,
      DegreeRepository degreeRepository) {
    this.departmentService = departmentService;
    this.degreeRepository = degreeRepository;
  }

  @Override public String execute(String arg) throws InvalidAttributeValueException {
    arg = ArgumentProcessor.processSingleQuoteArgument(arg);
    String result = arg;
    List<Lector> lectors = departmentService.getEmployers(arg);
        List < Degree > degrees = (List<Degree>) degreeRepository.findAll();

    for (Degree degree : degrees) {
      result += String.format("\n\t%s:\t%d", degree.getName(),
          lectors.stream().filter(lector -> lector.getDegree().getId().equals(degree.getId())).count());
    }
    return result;
  }
}
