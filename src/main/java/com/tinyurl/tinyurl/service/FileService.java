package com.tinyurl.tinyurl.service;

import java.util.List;

public interface FileService {
    public void addUrl(String userUrl, String tinyUrl);
    public boolean deleteTinyUrl(String tu);
    public boolean updateUrl(String userUrl, String tinyUrl);
    public String getUrl(String tinyUrl);
}
