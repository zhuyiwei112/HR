package com.hr.service.impl;

import com.hr.dao.DepTrainDao;
import com.hr.dao.TrainDao;
import com.hr.model.DepTrain;
import com.hr.model.Train;
import com.hr.service.DepTrainSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepTrainServiceImpl implements DepTrainSerivce {
    @Resource
    private DepTrainDao depTrainDao;
    @Resource
    private TrainDao trainDao;


    @Override
    public boolean addDT(Integer[] ids,Integer tid) {
        if (ids!=null&&ids.length!=0&&tid!=null){
            Train train = new Train();
            train.setId(tid);
            train.setIsPublish(1);
            trainDao.updateTrain(train);
            DepTrain depTrain = new DepTrain();
            depTrain.setTid(tid);
            for (int i=0;i<ids.length;i++){
                depTrain.setDid(ids[i]);
                depTrainDao.addDT(depTrain);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<DepTrain> getDTByDid(Integer did) {
        if (did!=null){
            return depTrainDao.getDTByDid(did);
        }
        return null;
    }
}
