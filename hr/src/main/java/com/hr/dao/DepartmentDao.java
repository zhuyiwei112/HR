package com.hr.dao;

import com.hr.model.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getALLDepartments();
    Department getDepartmentByName(String name);
    boolean addDepartment(Department department);
    boolean delDepartment(Integer id);
    boolean updateDepartment(Department department);
}
