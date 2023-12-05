package com.shey.dao;


import com.shey.entity.Cargo;
import com.shey.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> userList() {
        String sql = "select * from users";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<User>(User.class), username, password) != null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userAdd(User user) {
        String sql = "insert into users values(default,?,?,?,?)";
        try {
            int i = getQueryRunner().update(sql, user.getUsername(), user.getPassword(), user.getIdentity(), user.getRemarks());
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userDelete(Integer userId) {
        String sql = "delete from users where user_id=?";
        try {
            int i = getQueryRunner().update(sql, userId);
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userUpdate(User user) {
        String sql = "update users set username=?,password=?,identity=?,remarks=? where user_id=?";
        try {
            int i = getQueryRunner().update(sql, user.getUsername(), user.getPassword(), user.getIdentity(), user.getRemarks(), user.getUser_id());
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User getUser(Integer userId) {
        String sql = "select * from users where user_id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<User>(User.class), userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(String username, String password) {
        String sql = "select * from users where username=? and password=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer userCount() {
        String sql = "select count(*) from users";
        try {
            Long count = getQueryRunner().query(sql, new ScalarHandler<>());
            return count != null ? count.intValue() : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Test
    public void test() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.userCount());
    }
}
