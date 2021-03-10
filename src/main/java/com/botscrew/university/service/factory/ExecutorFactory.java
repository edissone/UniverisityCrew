package com.botscrew.university.service.factory;

import com.botscrew.university.service.executor.AverageSalaryExecutor;
import com.botscrew.university.service.executor.CommandExecutor;
import com.botscrew.university.service.executor.CountOfEmployersExecutor;
import com.botscrew.university.service.executor.ExitExecutor;
import com.botscrew.university.service.executor.GlobalSearchExecutor;
import com.botscrew.university.service.executor.HeadOfDepartmentExecutor;
import com.botscrew.university.service.executor.HelpExecutor;
import com.botscrew.university.service.executor.ListOfExecutor;
import com.botscrew.university.service.executor.StatisticExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.botscrew.university.config.TemplateConfig.AVG_COMMAND;
import static com.botscrew.university.config.TemplateConfig.COUNT_COMMAND;
import static com.botscrew.university.config.TemplateConfig.EXIT_COMMAND;
import static com.botscrew.university.config.TemplateConfig.GLOBAL_COMMAND;
import static com.botscrew.university.config.TemplateConfig.HEAD_COMMAND;
import static com.botscrew.university.config.TemplateConfig.HELP_COMMAND;
import static com.botscrew.university.config.TemplateConfig.LIST_COMMAND;
import static com.botscrew.university.config.TemplateConfig.STATS_COMMAND;

@Component
public class ExecutorFactory {
  private static final Map<String, CommandExecutor> commands = new HashMap<>();

  public ExecutorFactory(HelpExecutor helpExecutor,
      AverageSalaryExecutor averageSalaryExecutor,
      ExitExecutor exitExecutor,
      HeadOfDepartmentExecutor headOfDepartmentExecutor,
      ListOfExecutor listOfExecutor,
      StatisticExecutor statisticExecutor,
      CountOfEmployersExecutor countOfEmployersExecutor,
      GlobalSearchExecutor globalSearchExecutor) {
    commands.put(HELP_COMMAND, helpExecutor);
    commands.put(AVG_COMMAND, averageSalaryExecutor);
    commands.put(EXIT_COMMAND, exitExecutor);
    commands.put(HEAD_COMMAND, headOfDepartmentExecutor);
    commands.put(LIST_COMMAND, listOfExecutor);
    commands.put(STATS_COMMAND, statisticExecutor);
    commands.put(COUNT_COMMAND, countOfEmployersExecutor);
    commands.put(GLOBAL_COMMAND, globalSearchExecutor);
  }

  public CommandExecutor getInstance(String command) {
    return commands.get(command.toLowerCase(Locale.ROOT));
  }
}
