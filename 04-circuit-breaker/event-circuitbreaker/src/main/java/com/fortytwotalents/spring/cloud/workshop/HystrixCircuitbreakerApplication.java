package com.fortytwotalents.spring.cloud.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

// http://localhost:8082/rest/events
// http://localhost:8082/feign/events

@EnableDiscoveryClient
// TODO 2: Enable the Hystrix feature with @EnableCircuitBreaker
@EnableCircuitBreaker
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class HystrixCircuitbreakerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// TODO 11: Enable the HystrixMetricsStreamServlet and run the hystrix
	// dashboard. Call it at http://localhost:9001/hystrix. Attention this
	// context path is unusual but default for hystrix dashboard. Chaning the
	// path might lead to display issues in the browser.
	@Bean
	public ServletRegistrationBean servletRegistration() {
		return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
	}

	public static void main(String[] args) {
		SpringApplication.run(HystrixCircuitbreakerApplication.class, args);
	}
}
