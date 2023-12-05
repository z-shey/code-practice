package com.shey.dao.api;

import com.shey.entity.Role;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface RoleDao {
    /**
     * 获取QueryRunner对象
     *
     * @return 返回一个QueryRunner对象，用于执行SQL查询和更新操作
     */
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    /**
     * 查询所有角色
     *
     * @return 所有角色的列表
     */
    List<Role> findAll();

    /**
     * 根据id查询角色
     *
     * @param id 角色id
     * @return 对应id的角色对象，如果不存在则返回null
     */
    Role findById(Integer id);

    /**
     * 添加角色
     *
     * @param role 要添加的角色对象
     */
    void add(Role role);

    /**
     * 更新角色信息
     *
     * @param role 要更新的角色对象
     */
    void update(Role role);

    /**
     * 删除角色
     *
     * @param id 要删除的角色id
     */
    void delete(Integer id);
}

