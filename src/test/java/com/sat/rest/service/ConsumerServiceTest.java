package com.sat.rest.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.sat.rest.facade.ConsumerFacade;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerServiceTest {
  
  @Mock
  ConsumerFacade consumerFacade;
  
  @InjectMocks
  ConsumerService consumerService;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testGetHello() {
    Mockito.when(consumerFacade.getHello()).thenReturn("hello");
    
    assertEquals("hello", consumerService.getHello());
    
    Mockito.verify(consumerFacade).getHello();
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