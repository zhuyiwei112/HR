package com.hr.controller;

import com.hr.model.Department;
import com.hr.model.Position;
import com.hr.model.Recruit;
import com.hr.service.DepartmentService;
import com.hr.service.PositionService;
import com.hr.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;

    @RequestMapping("goRC")
    public String goRC(){
        return "admin/employeement";
    }

    @RequestMapping(value = "goaddRC")
    public String goAddRC(String pname,String dname,HttpSession session) throws Exception{
        session.setAttribute("pname",pname);
        session.setAttribute("dname",dname);
        return "admin/addRC";
    }

    //删除招聘
    @RequestMapping("delRC")
    public void delRC(Integer id,HttpServletResponse response,Integer pid,HttpSession session) throws Exception{
        PrintWriter pw=response.getWriter();
        Recruit recruit1=new Recruit();
        List<Recruit> recruits1 = (List<Recruit>) session.getAttribute("recruits");
        if (recruits1!=null||recruits1.size()!=0){
            for (Recruit recruit : recruits1) {
                if (id==recruit.getId()){
                    recruit1=recruit;
                    break;
                }
            }
        }
        if (("").equals(recruit1.getTime())||recruit1.getTime()==null) {
            if (recruitService.delRecruit(id)) {
                pw.print("删除成功");
                List<Recruit> recruits = recruitService.getRecruitByPid(pid);
                session.setAttribute("recruits",recruits);
            } else {
                pw.print("删除失败");
            }
        }else {
            pw.print("已发布，无法删除");
        }

    }

    //发布招聘
    @RequestMapping("publishRC")
    public void publishRC(Recruit recruit,String publish,HttpServletResponse response,HttpSession session,Integer pid) throws Exception{
        PrintWriter pw=response.getWriter();
        //System.out.println(publish);
        if (publish.equals("发布")) {
            //System.out.println("发布:"+recruit);
            Date date = new Date();
            String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
            recruit.setTime(time);
            if (recruitService.updateRecruit(recruit)) {
                //System.out.println("update:true");
                List<Recruit> recruits = recruitService.getRecruitByPid(pid);
                session.setAttribute("recruits",recruits);
                pw.print("发布成功");
            } else {
                //System.out.println("update:false");
                pw.print("发布失败");
            }
        }else if (publish.equals("撤销")){
            //System.out.println("撤销:"+recruit);
            recruit.setTime("");
            if (recruitService.updateRecruit(recruit)){
                //System.out.println("撤销:true");
                List<Recruit> recruits = recruitService.getRecruitByPid(pid);
                session.setAttribute("recruits",recruits);
                pw.print("撤销成功");
            }else {
                //System.out.println("撤销:false");
                pw.print("撤销失败");
            }
        }else {
            pw.print("应该不会走这步");
        }
    }

    //查询招聘
    @RequestMapping("getRC")
    public String getRC(HttpSession session,String pname,String dname/*,HttpServletResponse response*/) throws Exception{
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        List<Position> positions=new ArrayList<>();
        Position position=new Position();
        if (departments!=null||departments.size()!=0){
            for (Department department : departments) {
                if (dname.equals(department.getName())){
                    positions = department.getPositions();
                    break;
                }
            }
        }
        if (positions!=null||positions.size()!=0){
            for (Position position1 : positions) {
                if (pname.equals(position1.getName())){
                    position=position1;
                    break;
                }
            }
        }
        List<Recruit> recruits1=recruitService.getAllRecruits();
        //System.out.println("allRC:"+recruits1);
        List<Recruit> recruits=new ArrayList<>();
        //Recruit recruit=new Recruit();
        if (recruits1!=null||recruits1.size()!=0){
            for (Recruit recruit : recruits1) {
                if (recruit.getPosition().getId()==position.getId()){
                    recruits.add(recruit);
                    //System.out.println("session:"+recruits);
                    session.setAttribute("recruits",recruits);
                }
            }
        }
        //System.out.println(recruits);
        //response.getWriter().print(123);
        return null;
    }

    //保存招聘
    @RequestMapping("addRC")
    public void addRC(Recruit recruit, HttpServletResponse response,HttpSession session) throws Exception{
        //System.out.println(recruit);
        PrintWriter pw=response.getWriter();
        if (recruit.getTheme()==null||"".equals(recruit.getTheme())){
            pw.print("招聘主题不能为空");
            return;
        }
        if (recruit.getRequest()==null||"".equals(recruit.getRequest())){
            pw.print("招聘要求不能为空");
            return;
        }
        if (recruit.getContent()==null||"".equals(recruit.getContent())){
            pw.print("招聘内容不能为空");
            return;
        }
        if (recruit.getNumber()==null||0>=(recruit.getNumber())){
            pw.print("招聘人数有误");
            return;
        }
        List<Position> positions=new ArrayList<>();
        Position position=new Position();
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        String dname = (String) session.getAttribute("dname");
        String pname = (String) session.getAttribute("pname");
        if (departments!=null||departments.size()!=0){
            for (Department department : departments) {
                if (dname.equals(department.getName())){
                    positions=department.getPositions();
                    break;
                }
            }
        }
        if (positions!=null||positions.size()!=0){
            for (Position position1 : positions) {
                if (pname.equals(position1.getName())){
                    position=position1;
                    break;
                }
            }
        }
        //System.out.println(position);
        recruit.setPosition(position);
        recruit.setTime("");
        if (recruit.getPosition()==null){
            pw.print("请选择部门职位");
        }
        //System.out.println(recruit);
        if (recruitService.addRecruit(recruit)){
            //System.out.println("add:true:"+recruit);
            pw.print("保存成功");
        }else {
            //System.out.println(2);
            pw.print("保存失败");
        }
    }

    @RequestMapping("visgorcinfo")
    public String visGoRCInfo(HttpSession session) throws Exception{
        List<Recruit> recruits = recruitService.getAllRecruits();
        session.setAttribute("RCs",recruits);
        return "getrcinfo";
    }
}
