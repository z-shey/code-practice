package com.shey.entity;

public class Warehouse {
    private Integer id;
    private String name;
    private String location;

    public Warehouse() {
    }

    /**
     * 构造函数
     *
     * @param id       仓库ID
     * @param name     仓库名称
     * @param location 仓库位置
     */
    public Warehouse(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    /**
     * 获取仓库ID
     *
     * @return 仓库ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置仓库ID
     *
     * @param id 仓库ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库名称
     *
     * @return 仓库名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置仓库名称
     *
     * @param name 仓库名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取仓库位置
     *
     * @return 仓库位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置仓库位置
     *
     * @param location 仓库位置
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
