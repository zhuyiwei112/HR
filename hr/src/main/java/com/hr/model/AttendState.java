package com.hr.model;

import java.io.Serializable;

public class AttendState implements Serializable {
    private Integer id;
    private String state;
    private Double amount;

    public AttendState() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AttendState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", amount=" + amount +
                '}';
    }
}
