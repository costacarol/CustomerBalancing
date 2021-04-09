package com.costacarol.customersuccessbalancing.model;

public class CustomerSuccess {

    private Integer ID;
    private Integer LEVEL;


    public CustomerSuccess(Integer id, Integer level) {
        this.ID = id;
        this.LEVEL = level;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getLEVEL() {
        return LEVEL;
    }

}
