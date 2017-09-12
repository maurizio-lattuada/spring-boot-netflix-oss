package com.fortytwotalents.spring.cloud.workshop.frontend.client;

import java.net.URI;
import java.util.Collection;

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

import com.fortytwotalents.spring.cloud.workshop.frontend.domain.EventModel;

@Component
public class RestTemplateEventClient {

	// TODO 14: Where is this expression coming from? When is it replaced?
	@Value("http://${event.service.name}/events")
	private String eventsBaseUrl;

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	public Collection<EventModel> findAllEventsWithRestTemplate() {

		ResponseEntity<Resources<EventModel>> response = restTemplate.exchange(
				RequestEntity.get(URI.create(eventsBaseUrl)).accept(MediaTypes.HAL_JSON).build(),
				new ParameterizedTypeReference<Resources<EventModel>>() {
				});

		return response.getBody().getContent();
	}

	public EventModel findEventWithRestTemplate(Long id) {

		ResponseEntity<Resource<EventModel>> response = restTemplate.exchange(
				RequestEntity.get(URI.create(eventsBaseUrl + "/" + id)).accept(MediaTypes.HAL_JSON).build(),
				new ParameterizedTypeReference<Resource<EventModel>>() {
				});

		EventModel event = response.getBody().getContent();

		return event;
	}

}
