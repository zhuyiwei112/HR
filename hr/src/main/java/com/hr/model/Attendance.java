package com.hr.model;

import java.io.Serializable;

public class Attendance implements Serializable {
    private Integer id;
    private String beginTime;
    private String endTime;
    private AttendState attendState;
    private Integer eid;

    public Attendance() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public AttendState getAttendState() {
        return attendState;
    }

    public void setAttendState(AttendState attendState) {
        this.attendState = attendState;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", attendState=" + attendState +
                ", eid=" + eid +
                '}';
    }
}
