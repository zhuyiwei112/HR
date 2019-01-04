package com.hr.dao;

import com.hr.model.Account;
import com.hr.model.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean addEmp(Employee employee);
    boolean updateEmp(Employee employee);
    List<Employee> getEmp();
    Employee getEmpByAid(Account account);
}
