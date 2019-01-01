package com.hr.service;

import com.hr.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartment();
    int addDepartment(Department department);
    boolean delDepartment(Department department);
    int updateDepartment(Department department);
}
