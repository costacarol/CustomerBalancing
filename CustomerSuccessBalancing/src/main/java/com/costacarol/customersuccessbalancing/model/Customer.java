package com.costacarol.customersuccessbalancing.model;

public class Customer {
    private Integer id;
    private Integer level;
    private Integer idCS;

    public Customer(Integer id, Integer level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getIdCS() {
        return idCS;
    }

    public void setIdCS(Integer idCS) {
        this.idCS = idCS;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", level=" + level +
                ", idCS=" + idCS +
                '}';
    }
}
