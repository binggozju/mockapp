package org.binggo.mockapp.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.binggo.mockapp.domain.Person;
import org.binggo.mockapp.domain.DetailedPerson;
import org.binggo.mockapp.mapper.PersonMapper;
import org.binggo.mockapp.common.MockAppException;

@Service
public class PersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	private PersonMapper personMapper;
	
	@Autowired
	public void setPersonMapper(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}

	public void addPerson(Person person) throws MockAppException {
		personMapper.insert(person);
	}
	
	public List<DetailedPerson> getAllDetailedPersons() throws MockAppException {
		List<DetailedPerson> detailedPersons = personMapper.getAllDetailedPersons();
		if (detailedPersons == null) {
			logger.error("fail to execute getAllDetailedPersons on database");
			throw new MockAppException("the result of executing getAllDetailedPersons is null");
		}
		return detailedPersons;
	}
}
