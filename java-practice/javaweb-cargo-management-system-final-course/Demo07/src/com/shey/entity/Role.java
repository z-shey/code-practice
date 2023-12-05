package com.shey.entity;

public class Role {
    private Integer id;
    private String role_name;

    public Role() {
    }

    /**
     * 构造函数
     *
     * @param id        角色ID
     * @param role_name 角色名称
     */
    public Role(Integer id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    /**
     * 获取角色ID
     *
     * @return 角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return 角色名称
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置角色名称
     *
     * @param role_name 角色名称
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
