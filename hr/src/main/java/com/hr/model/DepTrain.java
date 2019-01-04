package com.hr.model;

import java.io.Serializable;

public class DepTrain implements Serializable {
    private Integer id;
    private Integer did;
    private Integer tid;

    public DepTrain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "DepTrain{" +
                "id=" + id +
                ", dId=" + did +
                ", tId=" + tid +
                '}';
    }
}
