package com.hr.service;

import com.hr.model.Employee;
import com.hr.model.Position;

public interface PositionService {
    int addPosition(Position position);
    boolean delPosition(Integer id);
    int updatePosition(Position position);
    //Position getPosByEid(Employee employee);
}
