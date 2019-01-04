package com.hr.controller;

import com.hr.model.*;
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
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("addEmp")
    public void addEmp(HttpSession session, Integer pid, Integer rid, HttpServletResponse response)throws Exception{
        PrintWriter pw = response.getWriter();
        Account user = (Account) session.getAttribute("user");
        Employee employee=new Employee();
        employee.setAccount(user);
        employee.setPosition(new Position(pid));
        Date date = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        employee.setTime(time);
        DeliverRes deliver = new DeliverRes();
        Resume resume = new Resume();
        resume.setId(rid);
        deliver.setResume(resume);
        deliver.setTime("员工");
        //System.out.println("EMP:"+employee+"DEL:"+deliver);
        if (employeeService.addEmp(employee,deliver,user)){
            pw.print("确认成功");
        }else {
            pw.print("确认失败");
        }

    }
}
