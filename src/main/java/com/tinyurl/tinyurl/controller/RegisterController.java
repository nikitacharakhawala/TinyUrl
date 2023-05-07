package com.tinyurl.tinyurl.controller;

import com.tinyurl.tinyurl.dao.FileDao;
import com.tinyurl.tinyurl.dao.StorageDao;
import com.tinyurl.tinyurl.models.RegisterModel;
import com.tinyurl.tinyurl.models.ResponseHandler;
import com.tinyurl.tinyurl.models.TinyUrlModel;
import com.tinyurl.tinyurl.service.*;
import com.tinyurl.tinyurl.service.serviceimpl.DuplicateCheck;
import com.tinyurl.tinyurl.service.serviceimpl.GenerateTinyUrl;
import com.tinyurl.tinyurl.service.serviceimpl.TinyUrlFileService;
import com.tinyurl.tinyurl.service.serviceimpl.ValidateUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    ValidateService validator = new ValidateUrl();
    GenerateTinyUrlService generateTinyUrlService = new GenerateTinyUrl();
    DupCheckService dupCheckService=new DuplicateCheck();
    FileService fileService=new TinyUrlFileService();
    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<Object> register(@RequestBody RegisterModel url) {
        logger.info("Register start...");
        if (validator.validateURL(url.getUrl())) {
            if (!dupCheckService.isExisting(url.getUrl())) {
                String tinyUrl = generateTinyUrlService.generateTinyUrl(url.getUrl());
                fileService.addUrl(url.getUrl(), tinyUrl);
                TinyUrlModel tinyUrlModel = new TinyUrlModel(tinyUrl, url.getUrl());
                logger.info("Register end...");
                return ResponseHandler.generateResponse("Successfully generated", HttpStatus.OK, tinyUrlModel);
            }else{
                logger.info("Register end...");
                return ResponseHandler.generateResponse("Url already exist", HttpStatus.OK, null);
            }
        }else{
            logger.info("Register end...");
            return ResponseHandler.generateResponse("Invalid Url", HttpStatus.BAD_REQUEST, null);
        }
    }
}
