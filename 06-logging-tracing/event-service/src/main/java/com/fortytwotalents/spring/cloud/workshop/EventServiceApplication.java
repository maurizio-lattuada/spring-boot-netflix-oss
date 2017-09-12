package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("com.fortytwotalents.spring.cloud.workshop.backend.domain")
@EnableJpaRepositories("com.fortytwotalents.spring.cloud.workshop.backend.repository")
@ComponentScan("com.fortytwotalents.spring.cloud.workshop.backend.controller")
public class EventServiceApplication {

	@Bean
	public AlwaysSampler sleuthZipkinSampler() {
		return new AlwaysSampler();
	}

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}
}
