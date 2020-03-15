package com.sat.rest.facade;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import com.sat.rest.model.BloodBank;

public interface ConsumerFacade {

  public String getHello();
  
  public BloodBank getBloodBank(String bloodBankName) throws UnsupportedEncodingException;
  
  public BloodBank[] getBloodBankByCity(String city) throws UnsupportedEncodingException;
  
  public void addBloodBank(BloodBank bloodBank) throws UnsupportedEncodingException; 
  
}
