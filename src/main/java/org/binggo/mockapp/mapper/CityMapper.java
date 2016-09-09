package org.binggo.mockapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.binggo.mockapp.domain.City;

@Mapper
public interface CityMapper {
	// insert
    int insert(City record);
    
    // delete
    int deleteCityById(Integer id);
    
    // select
    City getCityById(Integer id);
    List<City> getAllCities();
    
    // update
    int updateCityById(@Param("id") Integer id, @Param("city") City city);
}