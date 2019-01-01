package com.hr.dao;

import com.hr.model.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PositionDao {
    Position getPositionByNameAndDid(Map<String,Object> map);
    boolean addPosition(Position position);
    //List<Position> getPosition();
    boolean delPosition(Position position);
    boolean updatePosition(Position position);
}
