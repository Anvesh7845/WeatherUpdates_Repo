package com.weather.api.endpoint;

import java.util.Map;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weather.api.service.WeatherUpdatesServiceImpl;

@RestController
public class WeatherUpdatesEndPoint {
	
	@Autowired
	WeatherUpdatesServiceImpl service;
	
	@GetMapping(value = "weather/controller/getDetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> getWeatherUpdates(@PathVariable("id") String location){
		Map response = service.getWeatherUpdates(location);
		return new ResponseEntity<Map>(response, HttpStatus.CREATED);
	}
}
