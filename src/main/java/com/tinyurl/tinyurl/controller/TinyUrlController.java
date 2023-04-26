package com.tinyurl.tinyurl.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class TinyUrlController
{
   // private static final Logger logger=LoggerFactory.getLogger(TinyUrlController.class);
    @GetMapping("/")
    public String getGreeting(){
        return "Namaste!";
    }
}
