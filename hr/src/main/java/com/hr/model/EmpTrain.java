package com.hr.model;

import java.io.Serializable;

public class EmpTrain implements Serializable {
    private Integer id;
    private Integer eid;
    private Integer tid;

    public EmpTrain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }


    @Override
    public String toString() {
        return "EmpTrain{" +
                "id=" + id +
                ", eId=" + eid +
                ", tId=" + tid +
                '}';
    }
}
