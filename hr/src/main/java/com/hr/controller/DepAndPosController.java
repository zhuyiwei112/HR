package com.hr.controller;

import com.hr.model.Department;
import com.hr.model.EmpState;
import com.hr.model.Employee;
import com.hr.model.Position;
import com.hr.service.DepartmentService;
import com.hr.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DepAndPosController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("getDep")
    public String getDep(HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        session.setAttribute("departments",departments);
        return "admin/dp";
    }

    @ResponseBody
    @RequestMapping("getPos")
    public List<Position> getPos(String depName, HttpSession session) throws Exception{
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        for (Department department : departments) {
            if (department.getName().equals(depName)){
                return department.getPositions();
            }
        }
        return null;
    }

    @RequestMapping("godep")
    public String goDep(HttpSession session,Integer cp) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        if (cp==null){
            cp=1;
        }
        int tp=0;
        int pageSize=5;
        if (departments!=null && departments.size()!=0){
            tp= (int) Math.ceil(1.0*departments.size()/pageSize);
            departments=departments.subList((cp-1)*pageSize,cp*pageSize>departments.size()?departments.size():cp*pageSize);
        }
        session.setAttribute("tp",tp);
        session.setAttribute("departments",departments);
        return "admin/dpinfo";
    }

    @RequestMapping("adddep")
    public void addDep(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String department = request.getParameter("department");
        Date date = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Department department1 = new Department(department, time);
        int i = departmentService.addDepartment(department1);
        PrintWriter pw = response.getWriter();
        if (department==null||department.equals("")){
            pw.print("输入内容不能为空");
            return;
        }
        if (i==0){
            pw.print("部门已存在");
        }
        if (i==1){
            pw.print("添加成功");
        }
        if (i==2){
            pw.print("添加失败");
        }
    }

    @RequestMapping("delDep")
    public void delDep(Integer id,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        List<Department> departments = departmentService.getDepartment();
        for (Department depar : departments) {
            List<Position> positions = depar.getPositions();
            if (positions!=null){
                for (Position pos : positions) {
                    List<Employee> employees = pos.getEmployees();
                    if (employees!=null){
                        for (Employee emp : employees) {
                            EmpState empState = emp.getEmpState();
                            if (!empState.equals("离职")){
                                pw.print("该部门还有员工");
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (departmentService.delDepartment(id)){
            pw.print("删除成功");
            return;
        }
        pw.print("删除失败");
    }

    @RequestMapping("addPos")
    public void addPos(Integer did,String name,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        if (name==null||name.equals("")){
            pw.print("输入的内容不能为空");
            return;
        }
        Date date = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Position position1 = new Position(name,time,new Department(did));
        int i = positionService.addPosition(position1);
        System.out.println(i);
        if (i==0){
            pw.print("该职位已存在");
            return;
        }
        if (i==1){
            pw.print("添加成功");
            return;
        }
        if (i==2){
            pw.print("添加失败");
            return;
        }
    }

    @RequestMapping("updateDep")
    public void updateDep(String name,Integer id ,HttpServletResponse response) throws Exception {
        PrintWriter pw = response.getWriter();
        if (name == null || name.equals("")) {
            pw.print("输入的内容不能为空");
            return;
        }
        int i = departmentService.updateDepartment(new Department(id, name));
        if (i==0) {
            pw.print("该部门已存在");
            return;
        }
        if (i==1) {
            pw.print("修改成功");
            return;
        }
        if (i==2) {
            pw.print("修改失败");
            return;
        }
    }

    @RequestMapping("getPosition")
    public String getPos(HttpSession session,Integer id,Integer cp) throws Exception{
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        for (Department department : departments) {
            if (department.getId()==id){
                List<Position> positions = department.getPositions();
                session.setAttribute("positions",positions);

            }
        }
        //return "admin/getPos";
        List<Position> list = (List<Position>) session.getAttribute("positions");
        if (cp==null){
            cp=1;
        }
        int tp=0;
        int pageSize=5;
        if (list!=null && list.size()!=0){
            tp= (int) Math.ceil(1.0*list.size()/pageSize);
            list=list.subList((cp-1)*pageSize,cp*pageSize>list.size()?list.size():cp*pageSize);
        }
        System.out.println(tp);
        session.setAttribute("tp1",tp);
        session.setAttribute("positions",list);
        return "admin/getPos";
    }
}
