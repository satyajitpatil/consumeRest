package com.sat.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.sat.rest.facade.ConsumerFacade;
import com.sat.rest.facade.impl.ConsumerFacadeImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ConsumerController.class)
public class ConsumerControllerTest2 {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ConsumerFacadeImpl consumerFacade;

  @Before
  public void setUp() throws Exception {}

  /*
   * @Test public void testGetNeo() {
   * 
   * }
   */

  @Test
  public void testGetHello() throws Exception {
    Mockito.when(consumerFacade.getHello()).thenReturn("hello");

    mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("test hello"));
    
    Mockito.verify(consumerFacade).getHello();
  }

}
