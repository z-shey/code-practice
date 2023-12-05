package com.shey.dao;

import com.shey.dao.api.RoleDao;
import com.shey.entity.Role;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> findAll() {
        String sql = "select * from role";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<Role>(Role.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Role findById(Integer id) {
        String sql = "select * from role where id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<Role>(Role.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Role role) {
        String sql = "insert into role values(default,?)";
        try {
            getQueryRunner().update(sql, role.getRole_name());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Role role) {
        String sql = "update role set role_name=? where id=?";
        try {
            getQueryRunner().update(sql, role.getRole_name(), role.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from role where id=?";
        try {
            getQueryRunner().update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        RoleDao roleDao = new RoleDaoImpl();
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(
                    role.getId() + " " +
                            role.getRole_name()
            );
        }
    }
}
