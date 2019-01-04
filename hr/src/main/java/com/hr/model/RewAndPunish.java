package com.hr.model;

import java.io.Serializable;

public class RewAndPunish implements Serializable {
    private Integer id;
    private String reason;
    private Double amount;
    private String time;
    private Integer eid;

    public RewAndPunish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "RewAndPunish{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", amount=" + amount +
                ", time='" + time + '\'' +
                ", eid=" + eid +
                '}';
    }
}
