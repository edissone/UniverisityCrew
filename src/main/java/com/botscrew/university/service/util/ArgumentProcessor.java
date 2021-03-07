package com.botscrew.university.service.util;

import javax.management.InvalidAttributeValueException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.botscrew.university.config.TemplateConfig.QUOTE_REGEX;

public class ArgumentProcessor {
  public static String processSingleQuoteArgument(String argument) throws InvalidAttributeValueException {
    Pattern pattern = Pattern.compile(QUOTE_REGEX);
    Matcher matcher = pattern.matcher(argument);
    if (matcher.find()) {
      argument = matcher.group();
      argument = argument.replaceAll("'", "");
      return argument;
    }
    else throw new InvalidAttributeValueException();
  }
}
