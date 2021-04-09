package com.costacarol.customersuccessbalancing.model;

public class Customer {
    private Integer ID;
    private Integer LEVEL;
    private Integer idCS;

    public Customer(Integer id, Integer level) {
        this.ID = id;
        this.LEVEL = level;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getLEVEL() {
        return LEVEL;
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
                "id=" + ID +
                ", level=" + LEVEL +
                ", idCS=" + idCS +
                '}';
    }
}
