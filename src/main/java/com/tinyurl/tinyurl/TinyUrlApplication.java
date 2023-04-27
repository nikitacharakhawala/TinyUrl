package com.tinyurl.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class TinyUrlApplication {
	private static final Logger logger=LoggerFactory.getLogger(TinyUrlApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TinyUrlApplication.class, args);
		logger.info("Server started...");
	}
}
