package com.botscrew.university.config;

public class TemplateConfig {
  public static final String QUOTE_REGEX = "'(.*?)'";
  public static final String NOT_FOUND = "Not found";

  public static final String ERROR_INVALID_COMMAND = "Error: invalid command";
  public static final String ERROR_NOT_FOUND = "Error: Not found";
  public static final String ERROR_INVALID_INPUT = "Error: Invalid input";
  public static final String ERROR_INVALID_VALUE = "Error: Invalid attribute value";

  public static final String UNIVERSITY_ARGUMENT = "universities";
  public static final String DEPARTMENT_ARGUMENT = "departments";
  public static final String LECTOR_ARGUMENT = "lectors";

  public static final String ARG_TEMPLATE = "$ARG";
  public static final String HEAD_TEMPLATE = "$HEAD";
  public static final String DEPARTMENT_TEMPLATE = "$DEPARTMENT";
  public static final String AVG_TEMPLATE = "$AVG";
  public static final String COUNT_TEMPLATE = "$COUNT";
  public static final String UNIVERSITY_TEMPLATE = "$UNIVERSITY";
  public static final String LECTOR_TEMPLATE = "$LECTOR";

  public static final String HELP_COMMAND = "help";
  public static final String AVG_COMMAND = "average salary in";
  public static final String EXIT_COMMAND = "exit";
  public static final String HEAD_COMMAND = "head of";
  public static final String LIST_COMMAND = "list of";
  public static final String STATS_COMMAND = "stats of";
  public static final String COUNT_COMMAND = "count of employers in";
  public static final String GLOBAL_COMMAND = "global search";

  public static final String COUNT_EMP_MESSAGE = String
      .format("%s has %s employers", DEPARTMENT_TEMPLATE, COUNT_TEMPLATE);
  public static final String HEAD_MESSAGE = String.format("Head of %s is %s", DEPARTMENT_TEMPLATE, HEAD_TEMPLATE);
  public static final String AVG_SALARY_MESSAGE = String
      .format("The average salary of %s is %s", DEPARTMENT_TEMPLATE, AVG_TEMPLATE);
  public static final String GLOBAL_SEARCH_MESSAGE =
      String.format(
          "Global search results : %s " +
              "\nUniversities: \n\t%s " +
              "\nDepartments : \n\t%s " +
              "\nLectors: \n\t%s",
          ARG_TEMPLATE, UNIVERSITY_TEMPLATE, DEPARTMENT_TEMPLATE, LECTOR_TEMPLATE
      );
}
