package com.sat.rest.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
	
	
	//build header
	private HttpHeaders buildHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		/*
		 * header.add("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
		 * header.add("x-Rapidapi-key",
		 * "2c8b4635a5mshc2b278f10cfcb83p1e6e1bjsnbc1825c043b6");
		 */
		return header;
	}

	//get Weather data
	public String getNeo() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>("body", buildHeaders());
		
		String url = "https://api.nasa.gov/neo/rest/v1/feed?"
				+ "start_date=2019-01-01"
				+ "&end_date=2019-01-01"
				+ "&api_key=WFDRyeuseaWEl4aqi97v32Dxt4Re1rranb1s3MNK";

	    String neo = restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();

	    return neo;
	    
		//Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		//return quote;
	}

}
