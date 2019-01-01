package com.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Position implements Serializable {
  private Integer id;
  private String name;
  private String time;
  private Department department;
  private List<Employee> employees = new ArrayList<>();

  public Position() {
  }

  public Position(Integer id) {
    this.id = id;
  }

  public Position(String name, String time, Department department) {
    this.name = name;
    this.time = time;
    this.department = department;
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

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

  @Override
  public String toString() {
    return "Position{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", time='" + time + '\'' +
            //", employees=" + employees +
            '}';
  }
}
