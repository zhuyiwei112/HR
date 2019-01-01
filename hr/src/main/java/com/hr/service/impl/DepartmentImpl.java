package com.hr.service.impl;

import com.hr.dao.DepartmentDao;
import com.hr.dao.PositionDao;
import com.hr.model.Department;
import com.hr.model.Position;
import com.hr.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private PositionDao positionDao;

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
    public boolean delDepartment(Department department) {
        if (department==null){
            return false;
        }
        departmentDao.delDepartment(department.getId());
        List<Position> positions = department.getPositions();
        if (positions!=null||positions.size()!=0){
            for (Position position : positions) {
                positionDao.delPosition(position);
            }
        }
        return true;
    }

    @Override
    public int updateDepartment(Department department) {
        if (department==null||department.equals("")){
            return -1;
        }
        Department department1 = departmentDao.getDepartmentByName(department.getName());
        if (department1==null){
            if (departmentDao.updateDepartment(department)){
                return 1;
            }
            return 2;
        }
        return 0;
    }

}
