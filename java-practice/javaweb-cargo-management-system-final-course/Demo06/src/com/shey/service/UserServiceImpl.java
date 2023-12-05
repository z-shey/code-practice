package com.shey.service;

import com.shey.dao.UserDao;
import com.shey.dao.UserDaoImpl;
import com.shey.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public boolean userAdd(User user) {
        return userDao.userAdd(user);
    }

    @Override
    public boolean userDelete(Integer userId) {
        return userDao.userDelete(userId);
    }

    @Override
    public boolean userUpdate(User user) {
        return userDao.userUpdate(user);
    }

    @Override
    public boolean isValid(String username, String password) {
        return userDao.isValid(username, password);
    }


    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User getUser(String username, String password) {
        return userDao.getUser(username, password);
    }

    @Override
    public Integer userCount() {
        return userDao.userCount();
    }
}
