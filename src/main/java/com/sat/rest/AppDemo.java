package com.sat.rest;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppDemo {

//private static final Logger LOGGER = LoggerFactory.getLogger(AppDemo.class);
	
	public static void main(String[]args)  throws ParseException {
		ApplicationContext applicationContext = SpringApplication.run(AppDemo.class, args);
	}

}
