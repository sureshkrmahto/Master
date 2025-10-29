package com.iluwatar.information.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inventory Application starts container (Spring Boot) and exposes the Inventory micro-service.
 
 * @author Suresh Mahto

 */
@SpringBootApplication
/**
 * @author Suresh Mahto
 */
public class InformationApplication {

  public static void main(String[] args) {
    SpringApplication.run(InformationApplication.class, args);
  }
}
