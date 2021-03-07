package com.botscrew.university;

import com.botscrew.university.service.executor.MainExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

  @Autowired
  private MainExecutor mainExecutor;

  public static void main(String[] args) {
    SpringApplication.run(UniversityApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Java developer test task for BotsCrew. \nType 'help' to check all commands");
		mainExecutor.execute(null);
  }
}
