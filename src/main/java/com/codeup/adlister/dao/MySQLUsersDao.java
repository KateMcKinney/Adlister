package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.Config;
import java.sql.*;
public class MySQLUsersDao implements Users {
    private Connection connection;
    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "DELETE FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }
    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getHash());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void deleteUser(String username) {
        String query = "DELETE FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public User editUsername(Long id) {
        String query = "UPDATE users SET username=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "username"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractUser(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit username", e);
        }
    }

    @Override
    public User editEmail(Long id) {
        String query = "UPDATE users SET email=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "email"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractUser(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit email", e);
        }
    }

    @Override
    public User editPassword(Long id) {
        String query = "UPDATE users SET password=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "password"); //we'll have to replace hard-coded string username with input on whatever form we're using to let user do it
            stmt.setLong(2, id);
            return extractUser(stmt.executeQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Error while trying to edit password", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}