package com.tinyurl.tinyurl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinyUrlApplication {
    private static final Logger logger = LoggerFactory.getLogger(TinyUrlApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(TinyUrlApplication.class, args);
        logger.info("Server started...");
    }

}
