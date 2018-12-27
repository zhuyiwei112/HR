package com.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private Integer id;
    private String name;
    private String time;
    private List<Position> positions = new ArrayList<>();

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", positions=" + positions +
                '}';
    }
}
