package com.fortytwotalents.spring.cloud.workshop.circuitbreaker.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.domain.EventModel;

@FeignClient(name = "${event.service.name}", fallback = FeignFallbackEventClient.class)
public interface FeignCircuitbreakerEventClient {

	@RequestMapping(method = RequestMethod.GET, path = "/events")
	Resources<EventModel> getEvents();

	@RequestMapping(method = RequestMethod.GET, path = "/events/{id}")
	Resource<EventModel> getEvent(@PathVariable("id") long id);
}