package com.shey.dao;

import com.shey.entity.Cargo;
import com.shey.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CargoDaoImpl implements CargoDao {
    @Override
    public List<Cargo> cargoList() {
        String sql = "select * from cargos";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<Cargo>(Cargo.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cargoAdd(Cargo cargo) {
        String sql = "insert into cargos values(default,?,?,?,?,?)";
        try {
            int i = getQueryRunner().update(sql, cargo.getCargo_name(), cargo.getCargo_type(), cargo.getQuantity(), cargo.getWarehouse_id(), cargo.getCargos_remarks());
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cargoDelete(Integer cargoId) {
        String sql = "delete from cargos where cargo_id=?";
        try {
            int i = getQueryRunner().update(sql, cargoId);
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cargoUpdate(Cargo cargo) {
        String sql = "update cargos set cargo_name=?,cargo_type=?,quantity=?,warehouse_id=?,cargos_remarks=? where cargo_id=?";
        try {
            int i = getQueryRunner().update(sql, cargo.getCargo_name(), cargo.getCargo_type(), cargo.getQuantity(), cargo.getWarehouse_id(), cargo.getCargos_remarks());
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cargo getCargo(Integer cargoId) {
        String sql = "select * from cargos where cargo_id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<Cargo>(Cargo.class), cargoId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer cargoCount() {
        String sql = "select count(*) from cargos";
        try {
            Long count = getQueryRunner().query(sql, new ScalarHandler<>());
            return count != null ? count.intValue() : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Test
    public void test() {
        CargoDao cargoDao = new CargoDaoImpl();
        System.out.println(cargoDao.cargoCount());
    }
}
