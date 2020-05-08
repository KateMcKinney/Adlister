package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public interface Ads { //Ads DAO Interface
    // View (all) ads
    List<Ad> all();

    // get a single ad by id
    Ad getById(long id);

    // Create a new ad and return the new ad's id
    Long insert(Ad ad);

    // Delete ad
    void deleteAd (long id);

    //Edit ad
    Ad editTitle (long id);

    Ad editDescription(long id);

    Ad editCategories (long id);


    // Get categories
    ArrayList<String> getCategories();

    //get ad that user has chosen
    Ad individualAd (long id);
}