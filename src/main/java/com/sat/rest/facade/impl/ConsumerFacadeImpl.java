package com.sat.rest.facade.impl;

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
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.sat.rest.facade.ConsumerFacade;
import com.sat.rest.model.BloodBank;
import com.sat.rest.model.Quote;

@Repository
@EnableAutoConfiguration
public class ConsumerFacadeImpl implements ConsumerFacade {

  @Value("${endpoint.url}")
  private String baseUrl;

  RestTemplate restTemplate = new RestTemplate();

  @Override
  public Quote getNeo() {
    Quote quote = restTemplate.getForObject(baseUrl, Quote.class);
    return quote;
  }

  @Override
  public String getHello() throws RuntimeException {
    // TODO Auto-generated method stub
    return "hello";
  }

}
