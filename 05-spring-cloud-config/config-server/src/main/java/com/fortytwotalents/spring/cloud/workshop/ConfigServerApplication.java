package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

// TODO 2: Enable the configuration server by adding @EnableConfigServer
@EnableConfigServer
// TODO 3: We also make sure that the config server is registered at Eureka with @EnableDiscoveryClient
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
