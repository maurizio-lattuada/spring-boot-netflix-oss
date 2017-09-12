package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

// TODO 2: Add @EnableAdminServer and @EnableDiscoveryClient to enable the dasboard.
@EnableAdminServer
@EnableDiscoveryClient
// TODO 3: Head over to http://localhost:7000 and browse through
@SpringBootApplication
public class MicroservicesAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAdminApplication.class, args);
	}
}
