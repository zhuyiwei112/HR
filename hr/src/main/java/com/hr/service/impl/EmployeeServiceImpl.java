package com.hr.service.impl;

import com.hr.dao.AccountDao;
import com.hr.dao.DeliverResDao;
import com.hr.dao.EmployeeDao;
import com.hr.model.Account;
import com.hr.model.DeliverRes;
import com.hr.model.Employee;
import com.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DeliverResDao deliverResDao;
    @Resource
    private AccountDao accountDao;

    @Override
    public boolean addEmp(Employee employee, DeliverRes deliverRes,Account account) {
        if (employee!=null&&deliverRes!=null){
            DeliverRes deliverRes1 = deliverResDao.getDResByRid(deliverRes.getResume().getId());
            deliverRes.setId(deliverRes1.getId());

            deliverResDao.updateDRes(deliverRes);
            accountDao.updateAccount(account);
            //System.out.println(employee);
            //System.out.println(employee.getAccount().getId());
            //System.out.println(employee.getPosition().getId());
            employeeDao.addEmp(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeDao.getEmp();
    }

    @Override
    public Employee getEmpByAid(Account account) {
        //System.out.println(account);
        if (account.getId()!=null){
            Employee employee = employeeDao.getEmpByAid(account);
            //System.out.println(employee);
            return employee;
        }
        return null;
    }
}
