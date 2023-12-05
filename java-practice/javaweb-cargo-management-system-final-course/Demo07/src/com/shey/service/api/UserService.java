package com.shey.service.api;

import com.shey.entity.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    List<User> getAllUsers();

    /**
     * 根据ID获取用户
     *
     * @param id 用户ID
     * @return 用户对象
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 有效返回用户，否则空
     */
    User login(String username, String password);
}
