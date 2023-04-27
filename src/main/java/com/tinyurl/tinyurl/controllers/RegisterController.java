package com.tinyurl.tinyurl.controllers;

import com.tinyurl.tinyurl.TinyUrlApplication;
import com.tinyurl.tinyurl.models.RegisterEntity;
import com.tinyurl.tinyurl.models.ShortenedUrlEntity;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RegisterController {
    private static final Logger logger=LoggerFactory.getLogger(TinyUrlApplication.class);

    @PostMapping(value = "/register")
    @ResponseBody
    public ShortenedUrlEntity registerURL(@RequestBody RegisterEntity request){

        return new ShortenedUrlEntity(request.getUrl(), request.getUrl());

    }
}
