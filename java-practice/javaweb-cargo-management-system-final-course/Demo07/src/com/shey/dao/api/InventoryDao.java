package com.shey.dao.api;

import com.shey.entity.Inventory;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface InventoryDao {
    /**
     * 获取QueryRunner对象
     *
     * @return 返回一个QueryRunner对象，用于执行SQL查询和更新操作
     */
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    /**
     * 查询所有库存
     *
     * @return 所有库存的列表
     */
    List<Inventory> findAll();

    /**
     * 根据id查询库存
     *
     * @param id 库存id
     * @return 对应id的库存对象，如果不存在则返回null
     */
    Inventory findById(Integer id);

    /**
     * 添加库存
     *
     * @param inventory 要添加的库存对象
     */
    void add(Inventory inventory);

    /**
     * 更新库存信息
     *
     * @param inventory 要更新的库存对象
     */
    void update(Inventory inventory);

    /**
     * 删除库存
     *
     * @param id 要删除的库存id
     */
    void delete(Integer id);
}

