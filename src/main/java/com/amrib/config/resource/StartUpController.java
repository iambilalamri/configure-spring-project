package com.amrib.config.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartUpController {

	@Value("${my.greeting}")
	private String myGreeting;

	@Value("${app.description}")
	private String description;

	@GetMapping("/greeting")
	public String greeting() {
		return myGreeting + ": " + description;
	}

}
