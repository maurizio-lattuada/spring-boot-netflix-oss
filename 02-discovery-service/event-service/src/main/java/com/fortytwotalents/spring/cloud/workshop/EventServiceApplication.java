package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// TODO 6: We have configured a spring data rest appliation with an in-memory
// database. Checkout the Repository and the Entity. Don't be surprised if you
// find just an interface for the repository. Spring data rest creates the proxy
// implementation and the HAL-REST service.

// TODO 8: Register the event-service in eureka with @EnableDiscoveryClient
@EnableDiscoveryClient

// TODO 9: Start the event-service and checkout the events via browser. Hint: http://localhost:9090/ is a good starting point

@SpringBootApplication
@EntityScan("com.fortytwotalents.spring.cloud.workshop.backend.domain")
@EnableJpaRepositories("com.fortytwotalents.spring.cloud.workshop.backend.repository")
@ComponentScan("com.fortytwotalents.spring.cloud.workshop.backend.controller")
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
}
