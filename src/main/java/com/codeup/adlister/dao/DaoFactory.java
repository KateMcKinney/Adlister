package com.codeup.adlister.dao;

import com.codeup.adlister.Config;

public class DaoFactory {

    private static Config config = new Config();

    // Factory part that creates the Ads DAO
    private static Ads adsDao;

    public static Ads getAdsDao() { //View ads
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }


    // Factory part that creates the User DAO
    private static Users usersDao;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
