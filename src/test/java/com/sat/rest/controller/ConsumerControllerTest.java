package com.sat.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.sat.rest.facade.ConsumerFacade;


@RunWith(MockitoJUnitRunner.class)
public class ConsumerControllerTest {
  
  @InjectMocks
  private ConsumerController consumerController;

  @Mock
  private ConsumerFacade ConsumerFacade;  
  
  @Before
  public void setUp() throws Exception {
    //ConsumerFacade = mock(ConsumerFacade.class);
  }

  @Test
  public void testGetNeo() {
    when(ConsumerFacade.getHello()).thenReturn("hello");
    //doThrow(new RuntimeException("exception ocurred")).when(ConsumerFacade).getHello();
    assertEquals("hello",ConsumerFacade.getHello());
    verify(ConsumerFacade).getHello();
  }
  
  @Test(expected = RuntimeException.class)
  public void testGetNeoexception() {
    doThrow(new RuntimeException("exception ocurred")).when(ConsumerFacade).getHello();
    assertEquals("hellooooo",ConsumerFacade.getHello());
    verify(ConsumerFacade).getHello();
  }

}
