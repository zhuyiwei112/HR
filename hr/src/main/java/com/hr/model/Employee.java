package com.hr.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;
    private String time;
    private Double salary;
    private EmpState empState;
    private Position position;
    private Account account;
    private Double bonus;

    public Employee() {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmpState getEmpState() {
        return empState;
    }

    public void setEmpState(EmpState empState) {
        this.empState = empState;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
