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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.binggo.mockapp.domain.City;
import org.binggo.mockapp.services.CityService;
import org.binggo.mockapp.common.MockAppException;
import org.binggo.mockapp.common.PageInfoExt;
import org.binggo.mockapp.common.ResponseCode;
import org.binggo.mockapp.common.APIResponse;

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
	public APIResponse addCity(@RequestBody City city) throws Exception {
		logger.debug(String.format("receive a post request to  /city: city.name=%s", city.getName()));
		
		try {
			cityService.addCity(city);
			
			return new APIResponse(ResponseCode.OK, null);
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to add the city '%s': %s", city.getName(), ex.getMessage()));	
			
			return new APIResponse(ResponseCode.FAILURE, null);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public APIResponse deleteCityById(@PathVariable("id") int id) throws Exception {
		logger.info(String.format("receive a delete request to /city: city_id=%d", id));
		
		try {
			cityService.deleteCityById(id);
			
			return new APIResponse(ResponseCode.OK, null);
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to delete the city by city id '%d'", id));
			
			return new APIResponse(ResponseCode.FAILURE, null);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public APIResponse updateCityById(@PathVariable("id") int id, @RequestBody City city) throws Exception {
		logger.info(String.format("receive a update request to /city/%d", id));
		
		try {
			cityService.updateCityById(id, city);
			
			return new APIResponse(ResponseCode.OK, null);
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to update the city by city id '%d'", id));
			
			return new APIResponse(ResponseCode.FAILURE, null);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public APIResponse getAllCitiesWithPaging(@RequestParam Map<String, String> params) throws Exception {
		logger.info("receive a select request to /city/list");
		String offset = params.get("offset") == null ? "0" : params.get("offset"); // page num
		String size = params.get("size") == null ? "10" : params.get("size"); // page size
		
		PageHelper.startPage(Integer.parseInt(offset), Integer.parseInt(size));
		
		List<City> cityList = cityService.getAllCities();
		PageInfoExt<City> cityPage = new PageInfoExt<City>(cityList);
		
		return new APIResponse(ResponseCode.OK, cityPage);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public APIResponse getCityById(@PathVariable("id") int id) throws Exception {
		logger.info(String.format("receive a select request to /city/%d", id));
		
		try {
			City city = cityService.getCityById(id);
			
			return new APIResponse(ResponseCode.OK, city);
			
		} catch (MockAppException ex) {
			logger.error(String.format("fail to get the city by id '%d'", id));
			
			return new APIResponse(ResponseCode.FAILURE, null);
		}
	}
}
