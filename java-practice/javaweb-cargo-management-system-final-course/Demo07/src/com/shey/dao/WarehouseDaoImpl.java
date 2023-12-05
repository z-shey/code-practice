package com.shey.dao;

import com.shey.dao.api.WarehouseDao;
import com.shey.entity.Warehouse;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class WarehouseDaoImpl implements WarehouseDao {
    @Override
    public List<Warehouse> findAll() {
        String sql = "SELECT * FROM Warehouse";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<>(Warehouse.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse findById(Integer id) {
        String sql = "SELECT * FROM Warehouse WHERE id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<>(Warehouse.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Warehouse warehouse) {
        String sql = "INSERT INTO Warehouse(name, location) VALUES(?,?)";
        try {
            getQueryRunner().update(sql, warehouse.getName(), warehouse.getLocation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Warehouse warehouse) {
        String sql = "UPDATE Warehouse SET name=?, location=? WHERE id=?";
        try {
            getQueryRunner().update(sql, warehouse.getName(), warehouse.getLocation(), warehouse.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Warehouse WHERE id=?";
        try {
            getQueryRunner().update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
