package com.codeup.adlister.models;

// Added "categories" as an ArrayList<String>

import java.util.ArrayList;
import java.util.Arrays;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private ArrayList<String> categories = new ArrayList<>();


    public  Ad(long id, long userId, String title, String description, String...categories) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories.addAll(Arrays.asList(categories));
    }

    public Ad(long userId, String title, String description, String...categories) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories.addAll(Arrays.asList(categories));
    }

    public Ad(long id, long user_id, String title, String description) {
    }

    public Ad(long id, String title, String description, String categories) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }
}
