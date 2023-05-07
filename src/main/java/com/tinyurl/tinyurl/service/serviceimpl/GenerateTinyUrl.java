package com.tinyurl.tinyurl.service.serviceimpl;
import com.tinyurl.tinyurl.dao.FileDao;
import com.tinyurl.tinyurl.dao.StorageDao;
import com.tinyurl.tinyurl.service.GenerateTinyUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GenerateTinyUrl implements GenerateTinyUrlService {
    private static final Logger logger= LoggerFactory.getLogger(GenerateTinyUrl.class);
    @Override
    public String generateTinyUrl(String userUrl) {
        logger.info("Generate url start...");
        StorageDao fileDao=new FileDao();
        List<String> urls=fileDao.getAll();
        String[] keyVal=urls.get(urls.size()-1).split("=");
        char nextChar;
        String nextUrl="";
        if(keyVal.length<2){
            nextUrl="/a";
        }else{
            nextChar= (char) (keyVal[1].charAt(keyVal[1].length()-1)=='z' ? 'a' : keyVal[1].charAt(keyVal[1].length()-1)+1);
            nextUrl=keyVal[1].charAt(keyVal[1].length()-1)=='z' ? keyVal[1]+nextChar : "/"+nextChar;
        }
        logger.info("Generate url end...");
        return nextUrl;
    }
}
