package org.binggo.mockapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import org.binggo.mockapp.domain.Person;
import org.binggo.mockapp.domain.DetailedPerson;
import org.binggo.mockapp.services.PersonService;
import org.binggo.mockapp.common.MockAppException;
import org.binggo.mockapp.common.ResponseCode;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	private PersonService personService;
	
	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addPerson(@RequestBody Person person) throws Exception {
		logger.debug(String.format("receive a post request to  /person: person.name=%s", person.getName()));
		
		try {
			personService.addPerson(person);
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to add the person '%s': %s", person.getName(), ex.getMessage()));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String getAllDetailedPersons() throws Exception {
		logger.info("receive a select request to /person/list");
		
		try {
			List<DetailedPerson> detailedPersonList = personService.getAllDetailedPersons();
			
			StringBuilder persons = new StringBuilder();
			for (DetailedPerson detailedPerson : detailedPersonList) {
				persons.append(detailedPerson.toString() + ",");
			}
			
			if (persons.length() > 0) {
				persons.deleteCharAt(persons.length() - 1);
			}
			
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\", \"persons\": [%s]}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg(), persons.toString());
	
		} catch (MockAppException ex) {
			logger.error(String.format("fail to list all the detailed persons: %s", ex));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
		
	}

}
