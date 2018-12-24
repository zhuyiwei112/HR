package com.hr.model;

import java.io.Serializable;

public class Position implements Serializable {
  private String id;
  private String name;
  private String time;
  private Department department;
  private Employee employee;

  public Position() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  @Override
  public String toString() {
    return "Position{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", time='" + time + '\'' +
            ", did='" +
            '}';
  }
}