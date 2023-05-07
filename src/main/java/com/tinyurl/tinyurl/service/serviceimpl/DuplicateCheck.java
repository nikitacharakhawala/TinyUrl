package com.tinyurl.tinyurl.service.serviceimpl;
import com.tinyurl.tinyurl.dao.FileDao;
import com.tinyurl.tinyurl.dao.StorageDao;
import com.tinyurl.tinyurl.service.DupCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class DuplicateCheck implements DupCheckService {
    private static final Logger logger= LoggerFactory.getLogger(DuplicateCheck.class);
    @Override
    public boolean isExisting(String userUrl) {
        logger.info("isExisting Start...");
        StorageDao storageDao=new FileDao();
        List<String> allUrls=storageDao.getAll();
        for(String url: allUrls){
            String[] keyVal=url.split("=");
            if(keyVal[0].equals(userUrl))
                return true;
        }
        logger.info("isExisting End...");
        return false;
    }
}
