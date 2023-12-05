package com.shey.dao.api;

import com.shey.entity.Product;
import com.shey.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface ProductDao {
    /**
     * 获取QueryRunner对象
     *
     * @return 返回一个QueryRunner对象，用于执行SQL查询和更新操作
     */
    default QueryRunner getQueryRunner() {
        return new QueryRunner(DBUtil.getDataSource());
    }

    /**
     * 查询所有商品
     *
     * @return 所有商品的列表
     */
    List<Product> findAll();

    /**
     * 根据id查询商品
     *
     * @param id 商品id
     * @return 对应id的商品对象，如果不存在则返回null
     */
    Product findById(Integer id);

    /**
     * 添加商品
     *
     * @param product 要添加的商品对象
     */
    void add(Product product);

    /**
     * 更新商品信息
     *
     * @param product 要更新的商品对象
     */
    void update(Product product);

    /**
     * 删除商品
     *
     * @param id 要删除的商品id
     */
    void delete(Integer id);
}
