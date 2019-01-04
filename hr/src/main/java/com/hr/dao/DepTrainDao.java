package com.hr.dao;

import com.hr.model.DepTrain;
import com.hr.model.Department;

import java.util.List;

public interface DepTrainDao {
    boolean addDT(DepTrain depTrain);
    List<DepTrain> getDTByDid(Integer did);
}
