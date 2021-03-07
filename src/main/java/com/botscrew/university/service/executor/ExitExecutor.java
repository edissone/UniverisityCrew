package com.botscrew.university.service.executor;

import org.springframework.stereotype.Component;

@Component
public class ExitExecutor implements CommandExecutor {
  @Override public String execute(String arg) {
    return "Bye";
  }
}
