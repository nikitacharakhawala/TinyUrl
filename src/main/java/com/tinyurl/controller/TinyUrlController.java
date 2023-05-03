package com.tinyurl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyUrlController {
    private static final Logger logger = LoggerFactory.getLogger(TinyUrlController.class);

    @GetMapping("/")
    public String greet() {
        logger.info("Inside root '/' controller");
        return "Namaste!";
    }

}

