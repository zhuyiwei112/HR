package com.hr.service;

import com.hr.model.EmpTrain;
import com.hr.model.Employee;

import java.util.List;

public interface EmpTrainService {
    boolean addET(Integer[] ids,Integer tid);
    List<EmpTrain> getEmpTrainByEid(Employee employee);
}
