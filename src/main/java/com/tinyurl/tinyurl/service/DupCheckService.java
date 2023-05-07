package com.tinyurl.tinyurl.service;

public interface DupCheckService {
    public boolean isExisting(String userUrl);
}
