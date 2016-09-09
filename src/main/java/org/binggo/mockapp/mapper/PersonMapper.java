package org.binggo.mockapp.mapper;

import java.util.List;

import org.binggo.mockapp.domain.Person;
import org.binggo.mockapp.domain.DetailedPerson;

public interface PersonMapper {
	
	int insert(Person person);
	
	// join select
	List<DetailedPerson> getAllDetailedPersons();

}