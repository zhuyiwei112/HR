package com.hr.model;

import java.io.Serializable;

public class EmpState implements Serializable {
    private Integer id;
    private String state;

    public EmpState() {
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

    @Override
    public String toString() {
        return "EmpState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
