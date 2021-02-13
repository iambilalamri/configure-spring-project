package com.amrib.config.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.config.db.DBSettings;

@RestController
public class StartUpController {

	@Value("${my.greeting: default msg}")
	private String myGreeting;

	@Value("${app.description}")
	private String description;

	@Value("Hello Static")
	public String staticMsg;

	@Value("${my.list.value}")
	List<String> myValues;

	@Value("#{${dbIncredent}}")
	private Map<String, String> mapValues;

	@Autowired
	private DBSettings dbSettings;

	@GetMapping("/startupone")
	public String startup() {
		return myGreeting + ": " + description + " = " + staticMsg + " = " + myValues + " **** " + mapValues;
	}

	@GetMapping("/from-configurationProperty")
	public String levelup() {
		return dbSettings.getConnection() + ": [" + dbSettings.getHost() + ":" + dbSettings.getPort() + "]";
	}
}
