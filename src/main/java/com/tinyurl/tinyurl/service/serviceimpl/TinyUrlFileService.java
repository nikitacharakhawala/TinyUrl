package com.tinyurl.tinyurl.service.serviceimpl;

import com.tinyurl.tinyurl.dao.FileDao;
import com.tinyurl.tinyurl.dao.StorageDao;
import com.tinyurl.tinyurl.service.FileService;

public class TinyUrlFileService implements FileService {
    StorageDao storageDao=new FileDao();
    @Override
    public void addUrl(String userUrl, String tinyUrl) {
        storageDao.addUrl(userUrl, tinyUrl);
    }
    @Override
    public boolean deleteTinyUrl(String tu) {
        return storageDao.deleteTinyUrl(tu);
    }
    @Override
    public boolean updateUrl(String userUrl, String tinyUrl) {
        return storageDao.updateUrl(userUrl, tinyUrl);
    }
    @Override
    public String getUrl(String tinyUrl) {
        return storageDao.getUrl(tinyUrl);
    }
}
