package com.weather.api.service;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

public interface WeatherUpdatesService {
	
	public Map getWeatherUpdates(String location);
}
