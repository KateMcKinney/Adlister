package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

public interface Users { //User DAO Interface
    // Find user?  Why is this here?
        // User findByUsername(String username);

    // Create user
    Long insert(User user);

    // Delete user
    void deleteUser (int id);

    // Edit user
    User editUser (User user);
}
