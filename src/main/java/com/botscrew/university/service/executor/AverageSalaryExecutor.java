package com.botscrew.university.service.executor;

import com.botscrew.university.service.entity.DepartmentService;
import com.botscrew.university.service.util.ArgumentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;

import static com.botscrew.university.config.TemplateConfig.AVG_SALARY_MESSAGE;
import static com.botscrew.university.config.TemplateConfig.AVG_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.DEPARTMENT_TEMPLATE;

@Service
public class AverageSalaryExecutor implements CommandExecutor {

  private final DepartmentService departmentService;

  @Autowired
  public AverageSalaryExecutor(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @Override public String execute(String arg) throws InvalidAttributeValueException {
    arg = ArgumentProcessor.processSingleQuoteArgument(arg);
    double avgSalary = departmentService.averageSalary(arg);
    return AVG_SALARY_MESSAGE.replace(DEPARTMENT_TEMPLATE, arg).replace(AVG_TEMPLATE, String.valueOf(avgSalary));
  }
}
