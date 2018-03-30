package com.rewardshoop.model;

public class OrdersStateDesc {
    private Integer state;

    private String desc;

    public OrdersStateDesc(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public OrdersStateDesc() {
        super();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}