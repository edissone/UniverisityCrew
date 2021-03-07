package com.botscrew.university.service.executor;

import com.botscrew.university.service.factory.ExecutorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.botscrew.university.config.TemplateConfig.ERROR_INVALID_INPUT;
import static com.botscrew.university.config.TemplateConfig.ERROR_INVALID_VALUE;
import static com.botscrew.university.config.TemplateConfig.ERROR_NOT_FOUND;
import static com.botscrew.university.config.TemplateConfig.ERROR_INVALID_COMMAND;

@Slf4j
@Service
public class MainExecutor {
  private final ExecutorFactory executorFactory;

  @Autowired
  public MainExecutor(ExecutorFactory executorFactory) {
    this.executorFactory = executorFactory;
  }

  public void execute(String arg) {
    CommandExecutor executor = null;
    do {
      System.out.print("University Crew | ");
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      try {
        String[] input = reader.readLine().split(":");
        executor = executorFactory.getInstance(input[0]);
        System.out.println(executor.execute((input.length == 1) || (input[1] == null) ? null : input[1]));
      } catch (EntityNotFoundException e) {
        System.out.println(ERROR_NOT_FOUND);
      } catch (IOException e) {
        System.out.println(ERROR_INVALID_INPUT);
      } catch (InvalidAttributeValueException e) {
        System.out.println(ERROR_INVALID_VALUE);
      } catch (NullPointerException e){
        System.out.println(ERROR_INVALID_COMMAND);
      }
    } while (!(executor instanceof ExitExecutor));
  }
}
