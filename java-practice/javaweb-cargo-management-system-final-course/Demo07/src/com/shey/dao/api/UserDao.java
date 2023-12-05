package com.shey.dao.api;

import com.shey.entity.User;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface UserDao {
    /**
     * 获取QueryRunner对象
     *
     * @return 返回一个QueryRunner对象，用于执行SQL查询和更新操作
     */
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    /**
     * 查询所有用户
     *
     * @return 所有用户的列表
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 对应id的用户对象，如果不存在则返回null
     */
    User findById(Integer id);

    /**
     * 添加用户
     *
     * @param user 要添加的用户对象
     */
    void add(User user);

    /**
     * 更新用户信息
     *
     * @param user 要更新的用户对象
     */
    void update(User user);

    /**
     * 删除用户
     *
     * @param id 要删除的用户id
     */
    void delete(Integer id);

    /**
     * 获取用户
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 查询存在用户，则返回用户，否则为空
     */
    User getUserByUsernamePassword(String username, String password);
}
