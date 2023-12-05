package com.shey.entity;


public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Integer identity;
    private String remarks;

    public User() {
    }

    public User(Integer user_id, String username, String password, Integer identity, String remarks) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.identity = identity;
        this.remarks = remarks;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

