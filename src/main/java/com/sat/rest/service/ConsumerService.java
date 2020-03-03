package com.sat.rest.service;


import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sat.rest.facade.impl.ConsumerFacadeImpl;
import com.sat.rest.model.BloodBank;
import com.sat.rest.model.Quote;

@Service
public class ConsumerService {

  @Autowired
  ConsumerFacadeImpl consumerFacadeImpl;

  // get Weather data
  public Quote getNeo() {
    return consumerFacadeImpl.getNeo();
  }
  
  public String getHello() {
    return consumerFacadeImpl.getHello();
  }

}
