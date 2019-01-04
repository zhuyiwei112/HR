package com.hr.service.impl;

import com.hr.dao.AttendanceDao;
import com.hr.model.AttendState;
import com.hr.model.Attendance;
import com.hr.service.AttendanceService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class AttendServiceImpl implements AttendanceService {
    @Resource
    private AttendanceDao attendanceDao;

    @Override
    public boolean addAD(Attendance attendance) {
        if (attendance!=null&&attendance.getBeginTime()!=null&&attendance.getEid()!=null){
            String time = new SimpleDateFormat("yyyy-MM").format(new Date());
            HashMap<String, Object> map = new HashMap<>();
            map.put("eid",attendance.getEid());
            map.put("month",time);
            Integer workDays = attendanceDao.getMonTime(map);
            try {
                Date clock = new SimpleDateFormat("HH:mm").parse(attendance.getBeginTime());
                Date regTime = new SimpleDateFormat("HH:mm").parse("09:01");
                String beginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
                attendance.setBeginTime(beginTime);
                AttendState as = new AttendState();
                as.setId(1);
                attendance.setAttendState(as);
                long timeReg = regTime.getTime();
                long time1 = clock.getTime();
                if (time1>timeReg){
                    if ((time1-timeReg)>=3*60*60*1000){
                        as.setId(6);
                        attendance.setAttendState(as);
                    }else {
                        as.setId(2);
                        attendance.setAttendState(as);
                    }
                }
                if (workDays>=22){
                    as.setId(5);
                    attendance.setAttendState(as);
                }
                String unique = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                HashMap<String,Object> map1=new HashMap<>();
                map1.put("date",unique);
                map1.put("eid",attendance.getEid());
                Attendance attendance1 = attendanceDao.getAD(map1);
                if (attendance1==null) {
                    return attendanceDao.addAD(attendance);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateAD(Attendance attendance) {
        return false;
    }

    @Override
    public Attendance getAD(Integer eid) {
        if (eid!=null){
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            HashMap<String, Object> map = new HashMap<>();
            map.put("eid",eid);
            map.put("date",date);
            return attendanceDao.getAD(map);
        }
        return null;
    }
}
