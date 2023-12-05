package com.shey.service;

import com.shey.dao.api.ProductDao;
import com.shey.dao.ProductDaoImpl;
import com.shey.entity.Product;
import com.shey.service.api.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        productDao.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.delete(id);
    }
}
