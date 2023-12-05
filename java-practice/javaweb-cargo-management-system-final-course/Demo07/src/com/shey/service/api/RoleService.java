package com.shey.service.api;

import com.shey.entity.Role;

import java.util.List;

/**
 * 角色服务接口
 */
public interface RoleService {
    /**
     * 获取所有角色
     * @return 角色列表
     */
    List<Role> getAllRoles();

    /**
     * 根据ID获取角色
     * @param id 角色ID
     * @return 角色对象
     */
    Role getRoleById(Integer id);

    /**
     * 添加角色
     * @param role 角色对象
     */
    void addRole(Role role);

    /**
     * 更新角色
     * @param role 角色对象
     */
    void updateRole(Role role);

    /**
     * 删除角色
     * @param id 角色ID
     */
    void deleteRole(Integer id);
}

