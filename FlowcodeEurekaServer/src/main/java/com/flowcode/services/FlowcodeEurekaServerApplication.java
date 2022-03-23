package com.flowcode.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlowcodeEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowcodeEurekaServerApplication.class, args);
    }

}
