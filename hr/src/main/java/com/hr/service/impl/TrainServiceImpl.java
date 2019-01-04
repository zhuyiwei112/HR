package com.hr.service.impl;

import com.hr.dao.TrainDao;
import com.hr.model.Train;
import com.hr.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    @Override
    public boolean addTrain(Train train) {
        if (train!=null){
            return trainDao.addTrain(train);
        }
        return false;
    }

    @Override
    public boolean delTrain(Train train) {
        if (train.getId()!=null){
            return  trainDao.delTrain(train);
        }
        return false;
    }

    @Override
    public boolean updateTrain(Train train) {
        if (train.getId()!=null){
            return trainDao.updateTrain(train);
        }
        return false;
    }

    @Override
    public List<Train> getAllTrains() {
        return trainDao.getTrain();
    }

    @Override
    public List<Train> getTrainByPublish(Integer isPublish) {
        if (isPublish!=null){
            Train train = new Train();
            train.setIsPublish(isPublish);
            return trainDao.getTrain(train);
        }
        return null;
    }
}
