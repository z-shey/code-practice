package com.shey.entity;

public class User {
    private Integer id;
    private Integer role_id;
    private String name;
    private String username;
    private String password;

    public User() {
    }

    /**
     * 构造函数
     *
     * @param id       用户ID
     * @param role_id  角色ID
     * @param name     用户姓名
     * @param username 用户名
     * @param password 密码
     */
    public User(Integer id, Integer role_id, String name, String username, String password) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色ID
     *
     * @return 角色ID
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置角色ID
     *
     * @param role_id 角色ID
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取用户姓名
     *
     * @return 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
