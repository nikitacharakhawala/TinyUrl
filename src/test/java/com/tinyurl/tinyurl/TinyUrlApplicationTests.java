package com.tinyurl.tinyurl;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNotNull;


import com.tinyurl.tinyurl.controller.TinyUrlController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class TinyUrlApplicationTests {
	@Autowired
	private TinyUrlController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}



}
