package com.fortytwotalents.spring.cloud.workshop.circuitbreaker.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import com.fortytwotalents.spring.cloud.workshop.circuitbreaker.domain.EventModel;

@Component
public class FeignFallbackEventClient implements FeignCircuitbreakerEventClient {

	private ArrayList<EventModel> cachedEvents = new ArrayList<>();

	@PostConstruct
	public void loadCachedEvents() {
		cachedEvents.add(new EventModel(new Date(), "Cached Web Technology Workshop", "From Zero to Hero!"));
		cachedEvents.add(new EventModel(new Date(), "Cached Angular Workshop", "Migrating your Apps to Angular 2."));
		cachedEvents.add(
				new EventModel(new Date(), "Cached Spring Cloud Workshop", "Spring in the Cloud gets even better."));
	}

	@Override
	public Resources<EventModel> getEvents() {

		return new Resources<EventModel>(cachedEvents, Collections.emptyList());
	}

	@Override
	public Resource<EventModel> getEvent(long id) {

		return new Resource<EventModel>(cachedEvents.get((int) id), Collections.emptyList());

	}

}
