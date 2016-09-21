package org.binggo.mockapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import org.binggo.mockapp.domain.Toy;

@RestController
@RequestMapping("/toy")
public class ToyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ToyController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public String PrintToy(@RequestBody Toy toy) {
		logger.info("receive a new toy: " + toy.toString());
		return "{\"retCode\": 0}";
	}

}
