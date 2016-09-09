package org.binggo.mockapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.binggo.mockapp.domain.City;
import org.binggo.mockapp.services.CityService;
import org.binggo.mockapp.common.MockAppException;
import org.binggo.mockapp.common.ResponseCode;
import org.binggo.mockapp.common.PagingParam;

@RestController
@RequestMapping("/city")
public class CityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	private CityService cityService;
	
	@Autowired
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addCity(@RequestBody City city) throws Exception {
		logger.debug(String.format("receive a post request to  /city: city.name=%s", city.getName()));
		
		try {
			cityService.addCity(city);	
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to add the city '%s': %s", city.getName(), ex.getMessage()));	
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public String deleteCityById(@PathVariable("id") int id) throws Exception {
		logger.info(String.format("receive a delete request to /city: city_id=%d", id));
		
		try {
			cityService.deleteCityById(id);
			return String.format("{\"retCode\": %d, \"retMsg\":\"%s\"}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to delete the city by city id '%d'", id));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public String updateCityById(@PathVariable("id") int id, @RequestBody City city) throws Exception {
		logger.info(String.format("receive a update request to /city/%d", id));
		
		try {
			cityService.updateCityById(id, city);
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to update the city by city id '%d'", id));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/list")
	public String getAllCitiesWithPaging(@RequestBody PagingParam pagingParam) throws Exception {
		logger.info("receive a select request to /city/list");
		
		PageHelper.startPage(pagingParam.getPageNum(), pagingParam.getPageSize());
		
		try {
			List<City> cityList = cityService.getAllCities();
			
			StringBuilder cities = new StringBuilder();
			for (City city : cityList) {
				cities.append(city.toString() + ",");
			}
			if (cities.length() > 0) {
				cities.deleteCharAt(cities.length() - 1);
			}

			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\", \"cities\": [%s]}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg(), cities.toString());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to list all the cities: %s", ex));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public String getCityById(@PathVariable("id") int id) throws Exception {
		logger.info(String.format("receive a select request to /city/%d", id));
		
		try {
			City city = cityService.getCityById(id);
			
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\", \"city\": %s}", ResponseCode.OK.getRetCode(), ResponseCode.OK.getRetMsg(), city.toString());
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to get the city by id '%d'", id));
			return String.format("{\"retCode\": %d, \"retMsg\": \"%s\"}", ResponseCode.FAILURE.getRetCode(), ResponseCode.FAILURE.getRetMsg());
		}
	}
}
