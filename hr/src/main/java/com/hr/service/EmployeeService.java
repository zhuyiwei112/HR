package com.hr.service;

import com.hr.model.Account;
import com.hr.model.DeliverRes;
import com.hr.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    boolean addEmp(Employee employee, DeliverRes deliverRes,Account account);
    List<Employee> getAllEmp();
    Employee getEmpByAid(Account account);
}
