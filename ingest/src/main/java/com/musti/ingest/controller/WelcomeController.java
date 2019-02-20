package com.musti.ingest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

	public static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	

	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> WelcomeMessage() {
		
		return new ResponseEntity<String>("Welcome to the Ingest Module", HttpStatus.OK);
	}

	

	

}