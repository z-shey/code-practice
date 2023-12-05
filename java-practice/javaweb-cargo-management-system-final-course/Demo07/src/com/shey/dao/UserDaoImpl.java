package com.shey.dao;

import com.shey.dao.api.UserDao;
import com.shey.entity.User;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(default,?,?,?,?)";
        try {
            getQueryRunner().update(sql, user.getRole_id(), user.getName(), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set role_id=?, name=?, username=?, password=? where id=?";
        try {
            getQueryRunner().update(sql, user.getRole_id(), user.getName(), user.getUsername(), user.getPassword(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id=?";
        try {
            getQueryRunner().update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByUsernamePassword(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        try {
            User user = getQueryRunner().query(sql, new BeanHandler<User>(User.class), username, password);
            if (user != null) {
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Test
    public void test() {
        UserDao userDao = new UserDaoImpl();

//        User newUser = new User();
//        newUser.setName("name");
//        newUser.setUsername("sername");
//        newUser.setPassword("password");
//        newUser.setRole_id(4);
//        userDao.add(newUser);

//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(
//                    user.getId() + " " +
//                            user.getRole_id() + " " +
//                            user.getName() + " " +
//                            user.getUsername() + " " +
//                            user.getPassword()
//            );
//        }
    }
}
