package com.shey.service.api;

import com.shey.entity.Warehouse;

import java.util.List;

/**
 * 仓库服务接口
 */
public interface WarehouseService {
    /**
     * 获取所有仓库
     * @return 仓库列表
     */
    List<Warehouse> getAllWarehouses();

    /**
     * 根据ID获取仓库
     * @param id 仓库ID
     * @return 仓库对象
     */
    Warehouse getWarehouseById(Integer id);

    /**
     * 添加仓库
     * @param warehouse 仓库对象
     */
    void addWarehouse(Warehouse warehouse);

    /**
     * 更新仓库
     * @param warehouse 仓库对象
     */
    void updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库
     * @param id 仓库ID
     */
    void deleteWarehouse(Integer id);
}

