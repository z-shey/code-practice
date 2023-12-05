package com.shey.entity;

public class Cargo {
    private Integer cargo_id;
    private String cargo_name;
    private String cargo_type;
    private Integer quantity;
    private Integer warehouse_id;
    private String cargos_remarks;

    public Cargo() {
    }

    public Cargo(Integer cargo_id, String cargo_name, String cargo_type, Integer quantity, Integer warehouse_id, String cargos_remarks) {
        this.cargo_id = cargo_id;
        this.cargo_name = cargo_name;
        this.cargo_type = cargo_type;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
        this.cargos_remarks = cargos_remarks;
    }

    public Integer getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(Integer cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    public String getCargo_type() {
        return cargo_type;
    }

    public void setCargo_type(String cargo_type) {
        this.cargo_type = cargo_type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getCargos_remarks() {
        return cargos_remarks;
    }

    public void setCargos_remarks(String cargos_remarks) {
        this.cargos_remarks = cargos_remarks;
    }
}

