package com.hr.dao;

import com.hr.model.EmpTrain;
import com.hr.model.Employee;

import java.util.List;

public interface EmpTrainDao {
    boolean addET(EmpTrain empTrain);
    List<EmpTrain> getETByEid(Employee employee);
}
