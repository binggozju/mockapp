package org.binggo.mockapp.mapper;

import java.util.List;

import org.binggo.mockapp.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.binggo.mockapp.domain.DetailedPerson;

@Mapper
public interface PersonMapper {
	
	// insert
	int insert(Person person);
	
	// join select
	List<DetailedPerson> getAllDetailedPersons();

}