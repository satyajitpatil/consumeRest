package com.sat.rest.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sat.rest.model.Quote;

@Service
public class ConsumerService {

	//get Weather data
	public Quote getNeo() {		
		RestTemplate restTemplate = new RestTemplate();	    
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

}
