package com.example.jsteam.model;

/**
 * @author kareltan
 */
public class User {

    private Integer userId;

    private String username;

    private String password;

    private String email;

    private String region;

    private String phoneNumber;

    public User(Integer userId, String username, String password, String email, String region, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.region = region;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
