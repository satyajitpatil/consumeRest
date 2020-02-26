package com.sat.rest.facade.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.sat.rest.facade.ConsumerFacade;
import com.sat.rest.model.Quote;

@Repository
public class ConsumerFacadeImpl implements ConsumerFacade {

  @Value("${endpoint.url}")
  private String baseUrl;

  @Override
  public Quote getNeo() {
    RestTemplate restTemplate = new RestTemplate();
    Quote quote = restTemplate.getForObject(baseUrl, Quote.class);
    return quote;
  }

}
