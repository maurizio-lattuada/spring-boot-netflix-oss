package com.fortytwotalents.spring.cloud.workshop.frontend.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortytwotalents.spring.cloud.workshop.frontend.domain.EventModel;

//@FeignClient("${event.service.name}")
@FeignClient(path="/events", name="${event.service.name}")
public interface FeignEventClient {

//	@RequestMapping(method = RequestMethod.GET, path = "/events")
	@RequestMapping(method = RequestMethod.GET)
	Resources<EventModel> getEvents();

//	@RequestMapping(method = RequestMethod.GET, path = "/events/{id}")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	Resource<EventModel> getEvent(@PathVariable("id") long id);
}