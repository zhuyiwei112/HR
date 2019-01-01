package com.hr.dao;

import com.hr.model.Position;
import com.hr.model.Recruit;

import java.util.List;

public interface RecruitDao {
    boolean addRecruit(Recruit recruit);
    boolean delRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    List<Recruit> getAllRecruits();
    List<Recruit> getRecruitByPid(Position position);

}
