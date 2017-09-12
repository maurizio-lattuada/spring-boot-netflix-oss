package com.fortytwotalents.spring.cloud.workshop.circuitbreaker.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.client.FeignCircuitbreakerEventClient;
import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.client.RestTemplateCircuitbreakerEventClient;
import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.domain.EventModel;

// TODO 7: Start the event-circuitbreaker with all the other services and make sure the app behaves as expected. -> e.g. http://localhost:8082/rest/events
// TODO 8: Shutdown event-service and see if the circuit breaker is working 
@Controller
public class FrontendController {

	@Autowired
	private RestTemplateCircuitbreakerEventClient restClient;

	@Autowired
	private FeignCircuitbreakerEventClient feignClient;

	@GetMapping("/rest/events")
	public String findAllEventsWithRestTemplate(Model model) {

		Collection<EventModel> events = restClient.findAllEventsWithRestTemplate();

		model.addAttribute("events", events);
		return "event-overview";
	}

	@GetMapping("/rest/events/{id}")
	public String findEventWithRestTemplate(@PathVariable Long id, Model model) {

		EventModel event = restClient.findEventWithRestTemplate(id);

		model.addAttribute("event", event);
		return "event-details";
	}

	@GetMapping("/feign/events")
	public String findAllEventsWithFeign(Model model) {

		Collection<EventModel> events = feignClient.getEvents().getContent();

		model.addAttribute("events", events);
		return "event-overview";
	}

	@GetMapping("/feign/events/{id}")
	public String findEventWithFeign(@PathVariable Long id, Model model) {

		EventModel event = feignClient.getEvent(id).getContent();

		model.addAttribute("event", event);
		return "event-details";
	}

}
