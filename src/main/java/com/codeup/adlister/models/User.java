package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
    private String email;
    private String hash;

    public User() {}

    public User(String username, String email, String hash) {
        this.username = username;
        this.email = email;
        this.hash = hash; // replaced all "password"s with "hash"
    }

//    public User(long id, String username, String email, String password) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    } // replaced all "password"s with "hash"

    public void setHash(String hash) {
        this.hash = hash;
    } // replaced all "password"s with "hash"
}
