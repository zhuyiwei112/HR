package com.hr.model;

import java.io.Serializable;

public class DeliverRes implements Serializable {
    private Integer id;
    private String time;
    private Integer isRead;
    private Recruit recruit;
    private Resume resume;

    public DeliverRes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "DeliverRes{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
