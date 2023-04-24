package com.tinyurl.tinyurl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TinyUrlController
{
    @GetMapping("/greetings")
    public String getGreeting(){
        return "Namaste";
    }
}
