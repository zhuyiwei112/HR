package com.hr.service.impl;

import com.hr.dao.RecruitDao;
import com.hr.model.Position;
import com.hr.model.Recruit;
import com.hr.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    @Override
    public boolean addRecruit(Recruit recruit) {
        if (recruit==null) {
            return false;
        }
        return recruitDao.addRecruit(recruit);
    }

    @Override
    public boolean delRecruit(Integer id) {
        if (id!=null) {
            return recruitDao.delRecruit(new Recruit(id));
        }else {
            return false;
        }
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        if (recruit.getId()!=null){
            return recruitDao.updateRecruit(recruit);
        }else {
            return false;
        }
    }

    @Override
    public List<Recruit> getAllRecruits() {
        return recruitDao.getAllRecruits();
    }

    @Override
    public List<Recruit> getRecruitByPid(Integer pid) {
        if (pid!=null){
            return recruitDao.getRecruitByPid(new Position(pid));
        }
        return null;
    }
}
