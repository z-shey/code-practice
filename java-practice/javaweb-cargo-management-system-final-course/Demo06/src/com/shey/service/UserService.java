package com.shey.service;

import com.shey.entity.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    boolean userAdd(User user);
    boolean userDelete(Integer userId);
    boolean userUpdate(User user);
    boolean isValid(String username, String password);
    User getUser(Integer userId);
    User getUser(String username,  String password);
    Integer userCount();
}
