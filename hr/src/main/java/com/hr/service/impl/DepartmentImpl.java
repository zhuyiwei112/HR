package com.hr.service.impl;

import com.hr.dao.DepartmentDao;
import com.hr.model.Department;
import com.hr.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartment() {
        return departmentDao.getALLDepartments();
    }

    @Override
    public int addDepartment(Department department) {
        if (department==null){
            return -1;
        }
        Department department1 = departmentDao.getDepartmentByName(department.getName());
        if (department1==null){
            if (departmentDao.addDepartment(department)){
                return 1;
            }else {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public boolean delDepartment(Integer id) {
        if (id==null){
            return false;
        }
        return departmentDao.delDepartment(id);
    }

}
