package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.codeup.adlister.Config;

import javax.management.Query;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Ad getById(long id){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            return extractAd(rs);
            return createAdsFromResults(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad id=" +id, e);
        }

    }

//    @Override
//    public Long insert(Ad ad) {
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
@Override
public Long insert(Ad ad) {
    try {
        String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setLong(1, ad.getUserId());
        stmt.setString(2, ad.getTitle());
        stmt.setString(3, ad.getDescription());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    } catch (SQLException e) {
        throw new RuntimeException("Error creating a new ad.", e);
    }
}

    @Override
    public void deleteAd(long id) {
        String query = "DELETE FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Ad editTitle(long id) {
        String query = "UPDATE ads SET title=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "title"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractAd(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit ad title", e);
        }
    }

    @Override
    public Ad editDescription(long id) {
        String query = "UPDATE ads SET description=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "description"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractAd(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit ad description", e);
        }
    }

    @Override
    public Ad editCategories(long id) {
        String query = "UPDATE ad_categories SET cat_id=? WHERE ad_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "password"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractAd(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit password", e);
        }
    }

    @Override
    public ArrayList<String> getCategories() {
        ArrayList<String> allCats = new ArrayList<>();
        try {

            String query = "SELECT * FROM categories";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                allCats.add(rs.getString("name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allCats;
    }


    @Override
    public Ad individualAd(long id) {
        System.out.println(id + " This is from line 133");
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by id", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description, categories) VALUES "
            + "(" + ad.getUserId() + ", "
            + "'" + ad.getTitle() +"', "
            + "'" + ad.getDescription() + "'"
            + "'" + ad.getCategories() + "')";
            // added categories, kinda, run JSP to further diagnose issue
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        ArrayList<String> catStrings = extractCategories(rs.getLong("id"));

        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            extractCategories(rs.getLong("id"))
        );
    }

    private ArrayList<String> extractCategories(long adId) throws SQLException {
        String query = "SELECT cat_id FROM ad_categories WHERE ad_id = " + adId;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<String> theseCats = new ArrayList<>();
        while (rs.next()){
            long catId = rs.getLong("cat_id");

            String queryCat = "SELECT name FROM categories WHERE id = " + catId;
            Statement stmtCat = connection.createStatement();
            ResultSet rsCat = stmt.executeQuery(query);

            while (rs.next()){
                theseCats.add(rs.getString("name"));
            }

        }
        return theseCats;
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
