package com.shey.service;

import com.shey.dao.api.WarehouseDao;
import com.shey.dao.WarehouseDaoImpl;
import com.shey.entity.Warehouse;
import com.shey.service.api.WarehouseService;

import java.util.List;


public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseDao warehouseDao;

    public WarehouseServiceImpl() {
        this.warehouseDao = new WarehouseDaoImpl();
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseDao.findAll();
    }

    @Override
    public Warehouse getWarehouseById(Integer id) {
        return warehouseDao.findById(id);
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {
        warehouseDao.add(warehouse);
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        warehouseDao.update(warehouse);
    }

    @Override
    public void deleteWarehouse(Integer id) {
        warehouseDao.delete(id);
    }
}
