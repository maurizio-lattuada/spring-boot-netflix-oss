package com.fortytwotalents.spring.cloud.workshop.circuitbreaker.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.domain.EventModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class RestTemplateCircuitbreakerEventClient {

	@Value("http://${event.service.name}/events")
	private String eventsBaseUrl;

	private ArrayList<EventModel> cachedEvents = new ArrayList<>();

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@PostConstruct
	public void loadCachedEvents() {
		cachedEvents.add(new EventModel(new Date(), "Cached Web Technology Workshop", "From Zero to Hero!"));
		cachedEvents.add(new EventModel(new Date(), "Cached Angular Workshop", "Migrating your Apps to Angular 2."));
		cachedEvents.add(
				new EventModel(new Date(), "Cached Spring Cloud Workshop", "Spring in the Cloud gets even better."));
	}

	// TODO 5: Add a @HystrixCommand and reference the right fall back method
	@HystrixCommand(fallbackMethod = "findAllEventsFallback")
	public Collection<EventModel> findAllEventsWithRestTemplate() {

		ResponseEntity<Resources<EventModel>> response = restTemplate.exchange(
				RequestEntity.get(URI.create(eventsBaseUrl)).accept(MediaTypes.HAL_JSON).build(),
				new ParameterizedTypeReference<Resources<EventModel>>() {
				});
		return response.getBody().getContent();
	}

	public Collection<EventModel> findAllEventsFallback() {
		return cachedEvents;
	}

	// TODO 6: Add a @HystrixCommand and reference the right fall back method
	@HystrixCommand(fallbackMethod = "findEventFallback")
	public EventModel findEventWithRestTemplate(Long id) {

		ResponseEntity<Resource<EventModel>> response = restTemplate.exchange(
				RequestEntity.get(URI.create(eventsBaseUrl + "/" + id)).accept(MediaTypes.HAL_JSON).build(),
				new ParameterizedTypeReference<Resource<EventModel>>() {
				});
		return response.getBody().getContent();
	}

	public EventModel findEventFallback(Long id) {
		return cachedEvents.get(id.intValue());
	}

}
