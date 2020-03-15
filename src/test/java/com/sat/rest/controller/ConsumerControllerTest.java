package com.sat.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.sat.rest.facade.ConsumerFacade;
import com.sat.rest.facade.impl.ConsumerFacadeImpl;
import com.sat.rest.service.ConsumerService;


@RunWith(SpringRunner.class)
@WebMvcTest(ConsumerController.class)
public class ConsumerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ConsumerService ConsumerService;

  @MockBean
  private ConsumerFacadeImpl ConsumerFacadeImpl;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testGetNeo() {

  }

  @Test
  public void testGetHello() throws Exception {

    Mockito.when(ConsumerFacadeImpl.getHello()).thenReturn("hello");

    mockMvc.perform(MockMvcRequestBuilders.get("/hello").contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("hello"));

    Mockito.verify(ConsumerFacadeImpl).getHello();

  }

}
