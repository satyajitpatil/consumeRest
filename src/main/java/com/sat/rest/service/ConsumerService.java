package com.sat.rest.service;


import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sat.rest.facade.impl.ConsumerFacadeImpl;
import com.sat.rest.model.BloodBank;

@Service
public class ConsumerService {


  @Autowired
  ConsumerFacadeImpl consumerFacadeImpl;

  public String getHello() {
    return consumerFacadeImpl.getHello();
  }
  

  public BloodBank getBloodBank(String bloodBankName) throws UnsupportedEncodingException{
    return consumerFacadeImpl.getBloodBank(bloodBankName);   
  }


  public BloodBank[] getBloodBankByCity(String city) throws UnsupportedEncodingException {
    return consumerFacadeImpl.getBloodBankByCity(city);
  }


  public void addBloodBank(BloodBank bloodBank) throws UnsupportedEncodingException {
    consumerFacadeImpl.addBloodBank(bloodBank);
  }

}
