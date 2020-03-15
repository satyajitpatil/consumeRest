package com.sat.rest.facade.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerFacadeImplTest {
  
  @Mock
  private ConsumerFacadeImpl consumerFacadeImpl;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testGetHello() {
    Mockito.when(consumerFacadeImpl.getHello()).thenReturn("hello");
    
    assertEquals("hello", consumerFacadeImpl.getHello());
    
    Mockito.verify(consumerFacadeImpl).getHello();
  }

  @Test
  public void testGetBloodBank() {
  }

  @Test
  public void testGetBloodBankByCity() {
  }

  @Test
  public void testAddBloodBank() {
  }

}
