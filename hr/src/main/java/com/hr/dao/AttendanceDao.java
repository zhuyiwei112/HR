package com.hr.dao;

import com.hr.model.Attendance;

import java.util.HashMap;
import java.util.List;

public interface AttendanceDao {
    boolean addAD(Attendance attendance);
    boolean updateAD(Attendance attendance);
    Attendance getAD(HashMap<String,Object> map);
    Integer getMonTime(HashMap<String,Object> map);
}
