package com.shey.dao;

import com.shey.dao.api.InventoryDao;
import com.shey.entity.Inventory;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class InventoryDaoImpl implements InventoryDao {
    @Override
    public List<Inventory> findAll() {
        String sql = "select * from inventory";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<Inventory>(Inventory.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Inventory findById(Integer id) {
        String sql = "select * from inventory where id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<Inventory>(Inventory.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Inventory inventory) {
        String sql = "insert into inventory values(default,?,?,?)";
        try {
            getQueryRunner().update(sql, inventory.getProduct_id(), inventory.getWarehouse_id(), inventory.getQuantity());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Inventory inventory) {
        String sql = "update inventory set product_id=?, warehouse_id=?, quantity=? where id=?";
        try {
            getQueryRunner().update(sql, inventory.getProduct_id(), inventory.getWarehouse_id(), inventory.getQuantity(), inventory.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from inventory where id=?";
        try {
            getQueryRunner().update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
