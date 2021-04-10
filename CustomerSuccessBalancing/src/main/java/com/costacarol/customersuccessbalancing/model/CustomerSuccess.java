package com.costacarol.customersuccessbalancing.model;

public class CustomerSuccess {

    private Integer id;
    private Integer level;


    public CustomerSuccess(Integer id, Integer level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

}
