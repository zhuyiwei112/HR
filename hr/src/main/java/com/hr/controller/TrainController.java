package com.hr.controller;

import com.hr.model.*;
import com.hr.service.*;
import com.hr.util.Paging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepTrainSerivce depTrainSerivce;
    @Resource
    private EmpTrainService empTrainService;

    @RequestMapping("getTrainInfo")
    public String getTrainInfo(HttpSession session,Integer cp){
        Account user = (Account) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        List<Train> list=new ArrayList<>();
        Employee employee = employeeService.getEmpByAid(user);
        //System.out.println(employee);
        List<Train> trains = trainService.getTrainByPublish(1);
        List<EmpTrain> empTrains = empTrainService.getEmpTrainByEid(employee);
        Integer did = employee.getPosition().getDepartment().getId();
        List<DepTrain> depTrains = depTrainSerivce.getDTByDid(did);
        if ((trains!=null||trains.size()!=0) && (empTrains!=null||empTrains.size()!=0)){
            for (Train train : trains) {
                for (EmpTrain empTrain : empTrains) {
                    if (train.getId()==empTrain.getTid()){
                        list.add(train);
                    }
                }
                for (DepTrain depTrain : depTrains) {
                    if (depTrain.getTid()==train.getId()){
                        list.add(train);
                    }
                }
            }
        }
        HashMap<String, Object> map = Paging.paging(list, 2, cp);
        Integer tp = (Integer) map.get("tp");
        List<Train> list1 = (List<Train>) map.get("list");
        session.setAttribute("tp",tp);
        session.setAttribute("trains",list1);
        return "employee/gettraininfo";
    }


    @RequestMapping("addTrainObj")
    public void addTrainObj(Integer[] ids,Integer tid,String type,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        //发布部门培训
        if ("depfix".equals(type)){
            if (depTrainSerivce.addDT(ids,tid)){
                pw.print("发布成功");
            }else {
                pw.print("发布失败");
            }
            return;
        }
        //员工培训
        if ("empfix".equals(type)){
            if (empTrainService.addET(ids,tid)){
                pw.print("发布成功");
            }else {
                pw.print("发布失败");
            }
        }
    }


    //选择培训对象
    @RequestMapping("goTrainObj")
    public String goTrainObj(Integer tid,HttpSession session,String type) throws Exception{
        session.setAttribute("tid",tid);
        if ("dep".equals(type)) {
            List<Department> departments = departmentService.getDepartment();
            session.setAttribute("departments",departments);
            session.setAttribute("type",type);
            return "admin/objTrain";
        }
        if ("emp".equals(type)){
            List<Employee> employees = employeeService.getAllEmp();
            session.setAttribute("employees",employees);
            session.setAttribute("type",type);
            return "admin/objTrain";
        }
        return null;
    }

    @RequestMapping("goAddTrain")
    public String goAddTrain(){
        return "admin/addTrain";
    }

    @RequestMapping("delTrain")
    public void delTrain(Train train,HttpServletResponse response)throws Exception{
        PrintWriter pw = response.getWriter();
        if (trainService.delTrain(train)){
            pw.print("删除成功");
        }else {
            pw.print("删除失败");
        }
    }

    @RequestMapping("updateTrain")
    public void updateTrain(Train train,Integer type,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        /**
         * 撤销培训
         */
        if (type==1){
            train.setIsPublish(2);
            if (trainService.updateTrain(train)){
                pw.print("撤销成功");
            }else {
                pw.print("撤销失败");
            }
        }
        /**
         * 发布培训
         */
    }

    @RequestMapping("getTrain")
    public String getTrain(HttpSession session,Integer type,Integer cp){
        //List<Train> trains = trainService.getAllTrains();
        //System.out.println(type);
        /**
         * 已发布
         */
        if (type==1) {
            List<Train> publish = trainService.getTrainByPublish(1);
            //System.out.println(publish);
            HashMap<String, Object> map = Paging.paging(publish, 5, cp);
            List<Train> train = (List<Train>) map.get("list");
            Integer tp = (Integer) map.get("tp");
            session.setAttribute("trains",train);
            session.setAttribute("tp",tp);
            session.setAttribute("type",1);
            //System.out.println(train);
            //System.out.println(tp);
            return "admin/traininfo";
        }
        /**
         *
         */
        if (type==0) {
            List<Train> unpublished = trainService.getTrainByPublish(0);
            //System.out.println(unpublished);
            HashMap<String, Object> map = Paging.paging(unpublished, 5, cp);
            List<Train> train = (List<Train>) map.get("list");
            Integer tp = (Integer) map.get("tp");
            session.setAttribute("trains",train);
            session.setAttribute("tp",tp);
            session.setAttribute("type",0);
            return "admin/traininfo";
        }
        return null;
    }

    @RequestMapping("addTrain")
    public void addTrain(Train train, HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        if (train.getRequest()==null||"".equals(train.getRequest())){
            pw.print("主题不能为空");
            return;
        }
        if (train.getBeginTime()==null||"".equals(train.getBeginTime())){
            pw.print("开始时间不能为空");
            return;
        }
        if (train.getEndTime()==null||"".equals(train.getEndTime())){
            pw.print("结束时间不能为空");
            return;
        }
        if (train.getContent()==null||"".equals(train.getContent())){
            pw.print("内容不能为空");
            return;
        }
        train.setIsPublish(0);
        if (trainService.addTrain(train)){
            pw.print("保存成功");
        }else {
            pw.print("保存失败");
        }
    }
}
