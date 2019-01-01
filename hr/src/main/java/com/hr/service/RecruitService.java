package com.hr.service;

import com.hr.model.Position;
import com.hr.model.Recruit;

import java.util.List;

public interface RecruitService {
    boolean addRecruit(Recruit recruit);
    boolean delRecruit(Integer id);
    boolean updateRecruit(Recruit recruit);
    List<Recruit> getAllRecruits();
    List<Recruit> getRecruitByPid(Integer pid);
}
