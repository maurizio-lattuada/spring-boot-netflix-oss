package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	// http://localhost:9001/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8081%2Fhystrix.stream

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
