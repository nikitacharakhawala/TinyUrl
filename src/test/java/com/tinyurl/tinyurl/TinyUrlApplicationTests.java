package com.tinyurl.tinyurl;

import static org.assertj.core.api.Assertions.assertThat;
import com.tinyurl.controller.TinyUrlController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TinyUrlApplicationTests {

	@Autowired
	private TinyUrlController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
