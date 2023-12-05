package com.shey.service;

import com.shey.dao.api.InventoryDao;
import com.shey.dao.InventoryDaoImpl;
import com.shey.entity.Inventory;
import com.shey.service.api.InventoryService;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDao inventoryDao;

    public InventoryServiceImpl() {
        this.inventoryDao = new InventoryDaoImpl();
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryDao.findAll();
    }

    @Override
    public Inventory getInventoryById(Integer id) {
        return inventoryDao.findById(id);
    }

    @Override
    public void addInventory(Inventory inventory) {
        inventoryDao.add(inventory);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryDao.update(inventory);
    }

    @Override
    public void deleteInventory(Integer id) {
        inventoryDao.delete(id);
    }
}
