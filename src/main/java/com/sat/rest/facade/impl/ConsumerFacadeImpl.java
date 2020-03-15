package com.sat.rest.facade.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Collections;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.sat.rest.facade.ConsumerFacade;
import com.sat.rest.model.BloodBank;
import com.sat.rest.model.Quote;

@Repository
@EnableAutoConfiguration
public class ConsumerFacadeImpl implements ConsumerFacade {

  @Value("${endpoint.url.BloodBank.ByName}")
  private String byNameUrl;
  
  @Value("${endpoint.url.BloodBank.ByCity}")
  private String byCityUrl;
  
  @Value("${endpoint.url.BloodBank.AddBloodBank}")
  private String addUrl;

  RestTemplate restTemplate = new RestTemplate();

  @Override
  public String getHello() throws RuntimeException {
    return "hello";
  }

  @Override
  public BloodBank getBloodBank(String bloodBankName) throws UnsupportedEncodingException {
    HttpEntity<BloodBank> entity = new HttpEntity<BloodBank>(getHttpHeaders());
    ResponseEntity<BloodBank> response = restTemplate.exchange(byNameUrl,HttpMethod.GET, entity, BloodBank.class);
    
    return response.getBody();
  }

  @Override
  public BloodBank[] getBloodBankByCity(String city) throws UnsupportedEncodingException {
    HttpEntity<BloodBank[]> entity = new HttpEntity<BloodBank[]>(getHttpHeaders());
    ResponseEntity<BloodBank[]> response = restTemplate.exchange(byCityUrl,HttpMethod.GET, entity, BloodBank[].class);
    
    return response.getBody();
  }

  @Override
  public void addBloodBank(BloodBank bloodBank) throws UnsupportedEncodingException {
    HttpEntity<BloodBank> entity = new HttpEntity<BloodBank>(getHttpHeaders());
    restTemplate.exchange(byNameUrl,HttpMethod.GET, entity, BloodBank.class);
  }

  
  //Headers
  private HttpHeaders getHttpHeaders() throws UnsupportedEncodingException {
    
    HttpHeaders headers = new HttpHeaders();
    String credentials = "user:pwd";
    String encoded = Base64.getEncoder().encodeToString(credentials.getBytes("utf-8"));
    String authHeader = "Basic "+encoded;
    headers.set("Authorization", authHeader);
    System.out.println(authHeader);
    return headers;
    
  }


}
