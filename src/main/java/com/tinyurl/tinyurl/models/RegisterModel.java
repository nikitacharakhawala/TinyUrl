package com.tinyurl.tinyurl.models;

public class RegisterModel {
    String url;

    public RegisterModel(){};

    public RegisterModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
