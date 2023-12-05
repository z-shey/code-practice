package com.shey.entity;

public class Warehouse {
    private Integer warehouse_id;
    private String warehouse_name;
    private String location;
    private Integer cargo_quantity;
    private Integer admin_id;
    private String warehouse_remarks;

    public Warehouse() {
    }

    public Warehouse(Integer warehouse_id, String warehouse_name, String location, Integer cargo_quantity, Integer admin_id, String warehouse_remarks) {
        this.warehouse_id = warehouse_id;
        this.warehouse_name = warehouse_name;
        this.location = location;
        this.cargo_quantity = cargo_quantity;
        this.admin_id = admin_id;
        this.warehouse_remarks = warehouse_remarks;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCargo_quantity() {
        return cargo_quantity;
    }

    public void setCargo_quantity(Integer cargo_quantity) {
        this.cargo_quantity = cargo_quantity;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getWarehouse_remarks() {
        return warehouse_remarks;
    }

    public void setWarehouse_remarks(String warehouse_remarks) {
        this.warehouse_remarks = warehouse_remarks;
    }
}
