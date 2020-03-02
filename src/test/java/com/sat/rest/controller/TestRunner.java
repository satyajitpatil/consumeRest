package com.sat.rest.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(ConsumerControllerTest.class);
      
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      
      System.out.println(result.wasSuccessful());
   }
}  
