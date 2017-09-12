package com.fortytwotalents.spring.cloud.workshop.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient

// TODO 11: The Feign and the RestTemplate clients are already implemented for
// you. Just enable the feign clients with @EnableFeignClients. For our special
// case, we are consuming perfect REST (HATEAOS -> HAL) we need to tell Feign
// about it with @EnableHypermediaSupport(type =
// EnableHypermediaSupport.HypermediaType.HAL)

@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class EventFrontendApplication {

	// TODO 12: Create a RestTemplate as a spring bean and annotated it with
	// @LoadBalanced. Ribbon will be added automatically.
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	// TODO 13: Run now all boot apps and try to get some data from the website.
	// Starting at http://localhost:8080 will result in a 404. Try /rest/events
	// or /feign/events instead.

	public static void main(String[] args) {
		SpringApplication.run(EventFrontendApplication.class, args);
	}
}
