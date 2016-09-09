package org.binggo.mockapp.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.binggo.mockapp.domain.City;
import org.binggo.mockapp.mapper.CityMapper;
import org.binggo.mockapp.common.MockAppException;

@Service
public class CityService {
	
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	private CityMapper cityMapper;
	
	@Autowired
	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}
	
	public void addCity(City city) throws MockAppException {
		cityMapper.insert(city);
	}
	
	public void deleteCityById(int id) throws MockAppException {
		cityMapper.deleteCityById(id);
	}
	
	public void updateCityById(int id, City city) throws MockAppException {
		cityMapper.updateCityById(id, city);
	}
	
	
	public List<City> getAllCities() throws MockAppException {
		List<City> cities = cityMapper.getAllCities();
		if (cities == null) {
			logger.error("fail to execute getAllCities on database");
			throw new MockAppException("the result of executing getAllCities is null");
		}
		return cities;
	}
	
	public City getCityById(int id) throws MockAppException {
		City city = cityMapper.getCityById(id);
		if (city == null) {
			logger.error("fail to execute getCityById on database");
			throw new MockAppException("the result of executing getCityById is null");
		}
		return city;
	}
}
