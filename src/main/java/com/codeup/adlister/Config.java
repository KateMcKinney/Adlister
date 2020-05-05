package com.codeup.adlister;

public class Config {
    //url host for mysql
    public String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    //mysql username
    public String getUsername() {
        return "root";
    }
    //mysql password
    public String getPassword() {
        return "*BlackKitty5";
    }
}