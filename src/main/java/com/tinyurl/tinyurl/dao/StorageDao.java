package com.tinyurl.tinyurl.dao;

import java.util.List;

public interface StorageDao {
    public void addUrl(String userUrl, String tinyUrl);

    public boolean deleteTinyUrl(String tu);

    public boolean updateUrl(String userUrl, String tinyUrl);

    public String getUrl(String tinyUrl);

    public List<String> getAll();
}
