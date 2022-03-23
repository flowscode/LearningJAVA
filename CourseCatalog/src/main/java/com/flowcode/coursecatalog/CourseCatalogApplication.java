package com.flowcode.coursecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
public class CourseCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseCatalogApplication.class, args);
    }

}
