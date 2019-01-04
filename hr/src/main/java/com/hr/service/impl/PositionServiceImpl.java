package com.hr.service.impl;

import com.hr.dao.PositionDao;
import com.hr.model.Department;
import com.hr.model.Employee;
import com.hr.model.Position;
import com.hr.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    @Override
    public int addPosition(Position position) {
        if (position==null){
            return -1;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("pname",position.getName());
        map.put("did",position.getDepartment().getId());
        /*System.out.println(position);
        System.out.println(map);*/
        Position position1 = positionDao.getPositionByNameAndDid(map);
        //System.out.println(position1);
        if (position1==null){
            if (positionDao.addPosition(position)){
                return 1;//成功
            }
            return 2;//失败
        }
        return 0;//存在
    }

    @Override
    public boolean delPosition(Integer id) {
        if (id==null) {
            return false;
        }
        Position position=new Position(id);
        return positionDao.delPosition(position);
    }

    @Override
    public int updatePosition(Position position) {
        if (position==null){
            return -1;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("pname",position.getName());
        map.put("did",position.getDepartment().getId());
        Position position1 = positionDao.getPositionByNameAndDid(map);
        if (position1==null){
            if (positionDao.updatePosition(position)){
                return 1;//成功
            }
            return 2;//失败
        }
        return 0;//存在
    }

}
