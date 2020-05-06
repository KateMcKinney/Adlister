package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads { //Ads DAO Interface
    // View (all) ads
    List<Ad> all();

    // Create a new ad and return the new ad's id
    Long insert(Ad ad);

    // Delete ad
    void deleteAd (long id);

    //Edit ad
    Ad editTitle (long id);

    Ad editDescription(long id);

    Ad editCategories (long id);

    //get ad that user has chosen
    Ad individualAd (long id);
}