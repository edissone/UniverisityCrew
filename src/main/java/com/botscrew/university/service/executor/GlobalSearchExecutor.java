package com.botscrew.university.service.executor;

import com.botscrew.university.service.entity.DepartmentService;
import com.botscrew.university.service.entity.LectorService;
import com.botscrew.university.service.entity.UniversityService;
import com.botscrew.university.service.ids.Describable;
import com.botscrew.university.service.util.ArgumentProcessor;
import com.botscrew.university.service.util.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.botscrew.university.config.TemplateConfig.ARG_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.DEPARTMENT_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.GLOBAL_SEARCH_MESSAGE;
import static com.botscrew.university.config.TemplateConfig.LECTOR_TEMPLATE;
import static com.botscrew.university.config.TemplateConfig.UNIVERSITY_TEMPLATE;

@Service
public class GlobalSearchExecutor implements CommandExecutor {
  private final DepartmentService departmentService;
  private final UniversityService universityService;
  private final LectorService lectorService;

  @Autowired
  public GlobalSearchExecutor(DepartmentService departmentService,
      UniversityService universityService, LectorService lectorService) {
    this.departmentService = departmentService;
    this.universityService = universityService;
    this.lectorService = lectorService;
  }

  @Override public String execute(String arg) throws InvalidAttributeValueException {
    arg = ArgumentProcessor.processSingleQuoteArgument(arg);

    String finalArg = arg;
    var ref = new Object() {
      String result = GLOBAL_SEARCH_MESSAGE.replace(ARG_TEMPLATE, finalArg);
    };

    Map<String, List<? extends Describable>> responses = new HashMap<>();
    responses.put(UNIVERSITY_TEMPLATE, universityService.search(arg));
    responses.put(DEPARTMENT_TEMPLATE, departmentService.search(arg));
    responses.put(LECTOR_TEMPLATE, lectorService.search(arg));

    responses.forEach((k, v) -> ref.result = (TextMapper.map(ref.result, k, v)));

    return ref.result;
  }
}
