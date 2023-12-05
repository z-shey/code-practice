package com.shey.service.api;

import com.shey.entity.Inventory;

import java.util.List;

/**
 * 库存服务接口
 */
public interface InventoryService {
    /**
     * 获取所有库存
     * @return 库存列表
     */
    List<Inventory> getAllInventories();

    /**
     * 根据ID获取库存
     * @param id 库存ID
     * @return 库存对象
     */
    Inventory getInventoryById(Integer id);

    /**
     * 添加库存
     * @param inventory 库存对象
     */
    void addInventory(Inventory inventory);

    /**
     * 更新库存
     * @param inventory 库存对象
     */
    void updateInventory(Inventory inventory);

    /**
     * 删除库存
     * @param id 库存ID
     */
    void deleteInventory(Integer id);
}

