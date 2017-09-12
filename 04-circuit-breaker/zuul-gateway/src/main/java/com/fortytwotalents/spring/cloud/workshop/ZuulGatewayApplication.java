package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.fortytwotalents.spring.cloud.workshop.filter.RequestLoggingFilter;
import com.netflix.zuul.ZuulFilter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	@Bean
	public ZuulFilter requestLoggingFilter() {
		return new RequestLoggingFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
