package com.tinyurl.tinyurl.service.serviceimpl;
import com.tinyurl.tinyurl.service.ValidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ValidateUrl implements ValidateService {
    private static final Logger logger= LoggerFactory.getLogger(ValidateUrl.class);
    @Override
    public boolean validateURL(String userUrl) {
        logger.info("Validate URL start...");
        try {
            URI url = new URL(userUrl).toURI();
            logger.info("Validate URL end...");
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            logger.info("Validate URL end exception...");
            e.fillInStackTrace();
            return false;
        }
    }
}
