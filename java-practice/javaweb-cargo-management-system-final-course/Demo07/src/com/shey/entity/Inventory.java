package com.shey.entity;

public class Inventory {
    private Integer id;
    private Integer product_id;
    private Integer warehouse_id;
    private Integer quantity;

    public Inventory() {
    }

    /**
     * 构造函数
     *
     * @param id           库存ID
     * @param product_id   产品ID
     * @param warehouse_id 仓库ID
     * @param quantity     库存数量
     */
    public Inventory(Integer id, Integer product_id, Integer warehouse_id, Integer quantity) {
        this.id = id;
        this.product_id = product_id;
        this.warehouse_id = warehouse_id;
        this.quantity = quantity;
    }

    /**
     * 获取库存ID
     *
     * @return 库存ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置库存ID
     *
     * @param id 库存ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品ID
     *
     * @return 产品ID
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * 设置产品ID
     *
     * @param product_id 产品ID
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * 获取仓库ID
     *
     * @return 仓库ID
     */
    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    /**
     * 设置仓库ID
     *
     * @param warehouse_id 仓库ID
     */
    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    /**
     * 获取库存数量
     *
     * @return 库存数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置库存数量
     *
     * @param quantity 库存数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

