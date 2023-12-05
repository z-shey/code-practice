package com.shey.service;

import com.shey.dao.api.UserDao;
import com.shey.dao.UserDaoImpl;
import com.shey.entity.User;
import com.shey.service.api.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.getUserByUsernamePassword(username, password);

        if (user != null) {
            return user;
        }

        return null;
    }
}
