package com.tinyurl.tinyurl.models;

public class TinyUrlModel {
    String longUrl;
    String shorternUrl;
    public TinyUrlModel(){

    }
    public TinyUrlModel(String longUrl, String shorternUrl) {
        this.longUrl = longUrl;
        this.shorternUrl = shorternUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShorternUrl() {
        return shorternUrl;
    }

    public void setShorternUrl(String shorternUrl) {
        this.shorternUrl = shorternUrl;
    }
}
