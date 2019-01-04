package com.hr.service.impl;

import com.hr.dao.EmpTrainDao;
import com.hr.dao.TrainDao;
import com.hr.model.EmpTrain;
import com.hr.model.Employee;
import com.hr.model.Train;
import com.hr.service.EmpTrainService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpTrainServiceImpl implements EmpTrainService {
    @Resource
    private EmpTrainDao empTrainDao;
    @Resource
    private TrainDao trainDao;

    @Override
    public boolean addET(Integer[] ids, Integer tid) {
        if (ids!=null&&ids.length!=0&&tid!=null){
            Train train = new Train();
            train.setId(tid);
            train.setIsPublish(1);
            trainDao.updateTrain(train);
            EmpTrain empTrain = new EmpTrain();
            empTrain.setTid(tid);
            for (int i=0;i<ids.length;i++){
                empTrain.setEid(ids[i]);
                empTrainDao.addET(empTrain);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<EmpTrain> getEmpTrainByEid(Employee employee) {
        if (employee.getId()!=null){
            return empTrainDao.getETByEid(employee);
        }
        return null;
    }
}
