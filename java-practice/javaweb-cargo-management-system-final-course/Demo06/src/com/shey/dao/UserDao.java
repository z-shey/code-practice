package com.shey.dao;

import com.shey.entity.User;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface UserDao {
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    List<User> userList();

    boolean isValid(String username, String password);

    boolean userAdd(User user);

    boolean userDelete(Integer userId);

    boolean userUpdate(User user);

    User getUser(Integer userId);

    User getUser(String username, String password);

    Integer userCount();
}
