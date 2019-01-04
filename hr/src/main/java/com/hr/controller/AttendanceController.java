package com.hr.controller;

import com.hr.dao.AttendanceDao;
import com.hr.dao.EmployeeDao;
import com.hr.model.Account;
import com.hr.model.Attendance;
import com.hr.model.Employee;
import com.hr.service.AttendanceService;
import com.hr.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private EmployeeService employeeService;

    //考勤打卡界面
    @RequestMapping("goAttend")
    public String goAttend(HttpSession session) throws Exception{
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            return "login";
        }else {
            Employee employee = employeeService.getEmpByAid(user);
            Attendance attendance = attendanceService.getAD(employee.getId());
            if (attendance != null && attendance.getBeginTime() != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(attendance.getBeginTime());
                String time = new SimpleDateFormat("HH:mm").format(date);
                attendance.setBeginTime(time);
            }
            //System.out.println(date+"----"+time);
            session.setAttribute("attendance", attendance);
            return "employee/signin";
        }
    }
    //上班打卡
    @RequestMapping("addAttend")
    public void addAttend(String beginTime, HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter pw = response.getWriter();
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            pw.print("请登入");
            return;
        }
        Attendance attendance = new Attendance();
        attendance.setBeginTime(beginTime);
        Employee employee = employeeService.getEmpByAid(user);
        attendance.setEid(employee.getId());
        if (attendanceService.addAD(attendance)){

        }else {
            pw.print("打卡失败");
        }

    }
    //下班打卡
    @RequestMapping("updateAttend")
    public void updateAttend(String endTime,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter pw = response.getWriter();
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            pw.print("请登入");
            return;
        }
    }
}
