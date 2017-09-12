package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.fortytwotalents.spring.cloud.workshop.filter.RequestLoggingFilter;

// TODO 2: Enable Zuul proxy with @EnableZuulProxy.
// TODO 4: Start the Zuul gateway app and try to access the event-service directly.
// ..../event-frontend/rest/events
// ..../event-service
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	// TODO 5: Adding the RequestLoggingFilter as a spring
	// bean. Zuul will take any registered ZuulFilter and uses it.
	// https://spring.io/guides/gs/routing-and-filtering/
	
	@Bean
	public RequestLoggingFilter getRequestLoggingFilter() {
		return new RequestLoggingFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
