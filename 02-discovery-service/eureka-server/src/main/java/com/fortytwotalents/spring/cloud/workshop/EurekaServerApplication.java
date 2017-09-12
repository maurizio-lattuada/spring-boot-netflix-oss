package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// TODO 3: Enable Eureka Server with @EnableEurekaServer and start the server.
@EnableEurekaServer
// TODO 4: Check for the Boot Dashboard for the available services
// TODO 5: Start Eureka Server now for the first time. Visit the console at http://localhost:8761
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
