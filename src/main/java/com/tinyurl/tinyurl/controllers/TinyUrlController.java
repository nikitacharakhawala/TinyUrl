package com.tinyurl.tinyurl.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class TinyUrlController
{
    @GetMapping("/")
    public String getGreeting(){
        return "Namaste!";
    }
}
