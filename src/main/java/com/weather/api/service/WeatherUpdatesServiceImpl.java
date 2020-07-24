package com.weather.api.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherUpdatesServiceImpl implements WeatherUpdatesService{
	public final RestTemplate restTemplate = new RestTemplate();
	public final String REST_SERVICE_URI = "http://api.weatherstack.com/current?";
	public final String ACCESS_KEY = "access_key=";
	public final String LOCATION_KEY = "&query=" ;
	public final String ACCESS_ID =   "28a20b20991feb262a191316d6d3d3ee";
	
	/*
	 * REST_SERVICE_URI = "http://api.weatherstack.com/current?"; public final
	 * String ACCESS_KEY = "access_key="; public final String LOCATION_KEY =
	 * "&query=" ; public final String ACCESS_ID =
	 * "28a20b20991feb262a191316d6d3d3ee";
	 */
	
	
	public Map getWeatherUpdates(String location){
		String restUri = REST_SERVICE_URI+ACCESS_KEY+ACCESS_ID+LOCATION_KEY+location;
		ResponseEntity<Map> respEntity = restTemplate.exchange(restUri, HttpMethod.GET, null, Map.class);
		return (Map) respEntity.getBody().get("current");
	}
}
