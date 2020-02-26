package com.sat.rest;

import java.text.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemo {

  // private static final Logger LOGGER = LoggerFactory.getLogger(AppDemo.class);

  public static void main(String[] args) throws ParseException {
    SpringApplication.run(AppDemo.class, args);
  }

}
