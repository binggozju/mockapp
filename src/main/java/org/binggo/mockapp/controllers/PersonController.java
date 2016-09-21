package org.binggo.mockapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import org.binggo.mockapp.domain.Person;
import org.binggo.mockapp.domain.DetailedPerson;
import org.binggo.mockapp.services.PersonService;
import org.binggo.mockapp.common.APIResponse;
import org.binggo.mockapp.common.MockAppException;
import org.binggo.mockapp.common.PageInfoExt;
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
	public APIResponse addPerson(@RequestBody Person person) throws Exception {
		logger.debug(String.format("receive a post request to  /person: person.name=%s", person.getName()));
		
		try {
			personService.addPerson(person);
			
			return new APIResponse(ResponseCode.OK, null);
			//return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to add the person '%s': %s", person.getName(), ex.getMessage()));
			
			return new APIResponse(ResponseCode.FAILURE, null);
			//return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public APIResponse getAllDetailedPersons(@RequestParam Map<String, String> params) throws Exception {
		logger.info("receive a select request to /person/list");
		String offset = params.get("offset") == null ? "0" : params.get("offset"); // page num
		String size = params.get("size") == null ? "10" : params.get("size"); // page size
		
		PageHelper.startPage(Integer.parseInt(offset), Integer.parseInt(size));
		
		try {
			List<DetailedPerson> detailedPersonList = personService.getAllDetailedPersons();
			PageInfoExt<DetailedPerson> personPage = new PageInfoExt<DetailedPerson>(detailedPersonList);
			
			return new APIResponse(ResponseCode.OK, personPage);
			
			//StringBuilder persons = new StringBuilder();
			//for (DetailedPerson detailedPerson : detailedPersonList) {
			//	persons.append(detailedPerson.toString() + ",");
			//}
			
			//if (persons.length() > 0) {
			//	persons.deleteCharAt(persons.length() - 1);
			//}
			//return String.format("{\"retCode\": %d, \"retMsg\": \"%s\", \"persons\": [%s]}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg(), persons.toString());
	
		} catch (MockAppException ex) {
			logger.error(String.format("fail to list all the detailed persons: %s", ex));
			
			return new APIResponse(ResponseCode.FAILURE, null);
			//return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
		
	}

}
