package com.shey.dao;

import com.shey.dao.api.ProductDao;
import com.shey.entity.Product;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(Integer id) {
        String sql = "SELECT * FROM Product WHERE id=?";
        try {
            return getQueryRunner().query(sql, new BeanHandler<>(Product.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO Product(name, description, price) VALUES(?,?,?)";
        try {
            getQueryRunner().update(sql, product.getName(), product.getDescription(), product.getPrice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE Product SET name=?, description=?, price=? WHERE id=?";
        try {
            getQueryRunner().update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Product WHERE id=?";
        try {
            getQueryRunner().update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
