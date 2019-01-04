package com.hr.service;

import com.hr.model.Train;

import java.util.List;

public interface TrainService {
    boolean addTrain(Train train);
    boolean delTrain(Train train);
    boolean updateTrain(Train train);
    List<Train> getAllTrains();
    List<Train> getTrainByPublish(Integer isPublish);
}
