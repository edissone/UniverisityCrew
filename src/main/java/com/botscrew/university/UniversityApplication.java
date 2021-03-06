package com.botscrew.university;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(UniversityApplication.class, args);
    log.info("Finished : {}", UniversityApplication.class.getSimpleName());
  }

  @Override
  public void run(String... args) throws Exception {
		log.info("Application started.");
  }
}
