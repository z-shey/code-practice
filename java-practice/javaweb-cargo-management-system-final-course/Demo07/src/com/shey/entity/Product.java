package com.shey.entity;

import java.math.BigDecimal;
import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    /**
     * 构造函数
     *
     * @param id          产品ID
     * @param name        产品名称
     * @param description 产品描述
     * @param price       产品价格
     */
    public Product(Integer id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * 获取产品ID
     *
     * @return 产品ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品ID
     *
     * @param id 产品ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品名称
     *
     * @return 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取产品描述
     *
     * @return 产品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置产品描述
     *
     * @param description 产品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取产品价格
     *
     * @return 产品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置产品价格
     *
     * @param price 产品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
