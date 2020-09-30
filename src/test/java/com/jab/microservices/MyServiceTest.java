package com.jab.microservices;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyServiceTest {
	
	@InjectMocks
	private MyService myService;

	@Test
	void greet() {
		String result = myService.greet();
		
		assertThat(result.equals("Hello, World"));
	}
}
