package com.botscrew.university.service.executor;

import com.botscrew.university.service.entity.DepartmentService;
import com.botscrew.university.service.util.ArgumentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;

import static com.botscrew.university.config.TemplateConfig.DEPARTMENT_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.HEAD_MESSAGE;
import static com.botscrew.university.config.TemplateConfig.HEAD_TEMPLATE;

@Service
public class HeadOfDepartmentExecutor implements CommandExecutor {
  private final DepartmentService departmentService;

  @Autowired
  public HeadOfDepartmentExecutor(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @Override
  public String execute(String arg) throws InvalidAttributeValueException {
    arg = ArgumentProcessor.processSingleQuoteArgument(arg);
    return HEAD_MESSAGE.replace(DEPARTMENT_TEMPLATE, arg)
        .replace(HEAD_TEMPLATE, departmentService.findByName(arg).getHead().desc());
  }
}
