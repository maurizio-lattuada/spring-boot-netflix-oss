package com.fortytwotalents.spring.cloud.workshop.backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO 4: If the value changes in cloud config and you use @RefreshScope you
//can refresh the whole application by calling http://${event-service}/refresh
//which is provided by the actuator
@RestController
class MessageController {

	// TODO 5: The value is not defined anywhere but has a default. It might be
	// overriden by cloud config (see config-repository)
	@Value("${message:Hello default}")
	private String message;

	@GetMapping("/message")
	public String getMessage() {
		return this.message;
	}
}