package com.fortytwotalents.spring.cloud.workshop.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fortytwotalents.spring.cloud.workshop.backend.domain.Event;

@RepositoryRestResource(collectionResourceRel = "events", itemResourceRel = "events", path = "events")
public interface EventRepository extends CrudRepository<Event, Long> {

	public Event findByName(@Param(value = "name") String name);

}
