package com.vuelos.PlaneModel.domain.entity;

public class Model {
    private Integer id;
    private String name;
    private Integer manufacturerId;

    public Model() {
    }

    public Model(Integer id, String name, Integer manufacturerId) {
        this.id = id;
        this.name = name;
        this.manufacturerId = manufacturerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}