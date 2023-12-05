package com.shey.dao.api;

import com.shey.entity.Warehouse;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface WarehouseDao {
    /**
     * 获取QueryRunner对象
     *
     * @return 返回一个QueryRunner对象，用于执行SQL查询和更新操作
     */
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    /**
     * 查询所有仓库
     *
     * @return 所有仓库的列表
     */
    List<Warehouse> findAll();

    /**
     * 根据id查询仓库
     *
     * @param id 仓库id
     * @return 对应id的仓库对象，如果不存在则返回null
     */
    Warehouse findById(Integer id);

    /**
     * 添加仓库
     *
     * @param warehouse 要添加的仓库对象
     */
    void add(Warehouse warehouse);

    /**
     * 更新仓库信息
     *
     * @param warehouse 要更新的仓库对象
     */
    void update(Warehouse warehouse);

    /**
     * 删除仓库
     *
     * @param id 要删除的仓库id
     */
    void delete(Integer id);
}

