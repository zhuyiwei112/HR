package com.hr.service;

import com.hr.model.Attendance;

import java.util.HashMap;

public interface AttendanceService {
    boolean addAD(Attendance attendance);
    boolean updateAD(Attendance attendance);
    Attendance getAD(Integer eid);
}
