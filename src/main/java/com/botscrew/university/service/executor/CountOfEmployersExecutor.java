package com.botscrew.university.service.executor;

import com.botscrew.university.service.entity.DepartmentService;
import com.botscrew.university.service.util.ArgumentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;

import static com.botscrew.university.config.TemplateConfig.AVG_SALARY_MESSAGE;
import static com.botscrew.university.config.TemplateConfig.AVG_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.COUNT_EMP_MESSAGE;
import static com.botscrew.university.config.TemplateConfig.COUNT_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.DEPARTMENT_TEMPLATE;

@Service
public class CountOfEmployersExecutor implements CommandExecutor {
  private final DepartmentService departmentService;

  @Autowired
  public CountOfEmployersExecutor(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @Override public String execute(String arg) throws InvalidAttributeValueException {
    arg = ArgumentProcessor.processSingleQuoteArgument(arg);
    String result = "";
    int countOfEmployers = departmentService.getCountOfEmployers(arg);
    return COUNT_EMP_MESSAGE.replace(DEPARTMENT_TEMPLATE, arg).replace(COUNT_TEMPLATE, String.valueOf(countOfEmployers));
  }
}
