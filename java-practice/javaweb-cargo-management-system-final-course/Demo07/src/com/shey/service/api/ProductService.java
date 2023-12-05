package com.shey.service.api;

import com.shey.entity.Product;

import java.util.List;

/**
 * 货物服务接口
 */
public interface ProductService {
    /**
     * 获取所有货物
     * @return 货物列表
     */
    List<Product> getAllProducts();

    /**
     * 根据ID获取货物
     * @param id 货物ID
     * @return 货物对象
     */
    Product getProductById(Integer id);

    /**
     * 添加货物
     * @param product 货物对象
     */
    void addProduct(Product product);

    /**
     * 更新货物
     * @param product 货物对象
     */
    void updateProduct(Product product);

    /**
     * 删除货物
     * @param id 货物ID
     */
    void deleteProduct(Integer id);
}

