package com.hr.service;

import com.hr.model.DepTrain;

import java.util.List;

public interface DepTrainSerivce {
    boolean addDT(Integer[] ids,Integer tid);
    List<DepTrain> getDTByDid(Integer did);
}
