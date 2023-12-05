package com.shey.service;

import com.shey.dao.api.RoleDao;
import com.shey.dao.RoleDaoImpl;
import com.shey.entity.Role;
import com.shey.service.api.RoleService;

import java.util.List;


public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl() {
        this.roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public void addRole(Role role) {
        roleDao.add(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.update(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.delete(id);
    }
}
