package com.jab.microservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class MyController2Test {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MyService myService;

	@Test
	void greeting() throws Exception {
		
		when(myService.greet()).thenReturn("Hello, Tony");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting");

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("Hello, Tony");
	}
}
