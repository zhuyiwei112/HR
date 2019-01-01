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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    //查询员工
    @ResponseBody
    @RequestMapping("getEmp")
    public List<Object> getEmpl(HttpSession session,String dname,String pname,Integer cp) throws Exception{

        List<Object> objects=new ArrayList<>();
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        List<Position> positions=new ArrayList<>();
        List<Employee> employees=new ArrayList<>();
        if (departments!=null||departments.size()!=0){
            for (Department department1 : departments) {
                if (dname.equals(department1.getName())){
                    positions= department1.getPositions();
                    break;
                }
            }
        }
        //System.out.println(positions);
        if (positions!=null||positions.size()!=0){
            for (Position position1 : positions) {
                if (pname.equals(position1.getName())){
                    //System.out.println(position1);
                    employees=position1.getEmployees();
                    break;
                }
            }
        }
        //System.out.println(employees.get(0).getEmpState().getState());
        //System.out.println(employees);
        if (cp==null){
            cp=1;
        }
        int tp=0;
        int pageSize=5;
        if (employees!=null && employees.size()!=0){
            tp= (int) Math.ceil(1.0*employees.size()/pageSize);
            employees=employees.subList((cp-1)*pageSize,cp*pageSize>employees.size()?employees.size():cp*pageSize);
        }
        objects.add(employees);
        objects.add(tp);
        return objects;
    }

    @RequestMapping("getDep")
    public String getDep(HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        session.setAttribute("departments",departments);
        return "admin/dp";
    }

    //二级联动
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

    //分页查部门
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

    //增加部门
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

    //删除部门
    @RequestMapping("delDep")
    public void delDep(Integer id,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        List<Department> departments = departmentService.getDepartment();
        Department department = new Department();
        if (departments!=null||departments.size()!=0) {
            for (Department depar : departments) {
                if (id==depar.getId()){
                    department=depar;
                    List<Position> positions = depar.getPositions();
                    if (positions != null || positions.size()!=0) {
                        for (Position pos : positions) {
                            List<Employee> employees = pos.getEmployees();
                            if (employees != null||employees.size()!=0) {
                                for (Employee emp : employees) {
                                    EmpState empState = emp.getEmpState();
                                    if (!empState.equals("离职")) {
                                        //System.out.println(depar);
                                        pw.print("该部门还有员工");
                                        return;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        if (departmentService.delDepartment(department)){
            pw.print("删除成功");
            return;
        }
        pw.print("删除失败");
    }

    //添加职位
    @RequestMapping("addPos")
    public void addPos(Integer did,String name,HttpServletResponse response) throws Exception{
        PrintWriter pw = response.getWriter();
        if (name==null||name.equals("")){
            pw.print("输入的内容不能为空");
            return;
        }
        Date date = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Department department=new Department(did);
        //System.out.println(department);
        Position position1 = new Position(name,time,department);
        //System.out.println(position1);
        int i = positionService.addPosition(position1);
        //System.out.println(i);
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

    //修改部门
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

    //修改职位
    @RequestMapping("updatePos")
    public void updatePos(String dname, String pname,HttpServletResponse response,HttpSession session) throws Exception{
        PrintWriter pw=response.getWriter();
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        List<Position> positions = new ArrayList<>();
        Position position = new Position();
        Department department1 = new Department();
        if (departments!=null||departments.size()!=0){
            for (Department department : departments) {
                if (dname.equals(department.getName())) {
                    department1=department;
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
        position.setDepartment(department1);
        int i = positionService.updatePosition(position);
        if (i==0){
            pw.print("职位已存在");
            return;
        }
        if (i==1){
            pw.print("修改成功");
            return;
        }
        if (i==2){
            pw.print("修改失败");
            return;
        }
    }

    //删除职位
    @RequestMapping("delPos")
    public void delPos(String pname,String dname,HttpServletResponse response,HttpSession session) throws Exception{
        PrintWriter pw = response.getWriter();
        List<Department> departments = (List<Department>) session.getAttribute("departments");
        if (departments!=null||departments.size()!=0) {
            for (Department department : departments) {
                if (dname.equals(department.getName())) {
                    List<Position> positions = department.getPositions();
                    if (positions!=null||positions.size()!=0) {
                        for (Position position : positions) {
                            if (pname.equals(position.getName())) {
                                List<Employee> employees = position.getEmployees();
                                if (employees!=null||employees.size()!=0){
                                    for (Employee employee : employees) {
                                        EmpState empState = employee.getEmpState();
                                        if (!"离职".equals(empState.getState())) {
                                            pw.print("该职位还有员工");
                                            return;
                                        }
                                    }
                                }
                                if (positionService.delPosition(position.getId())){
                                    pw.print("删除成功");
                                    return;
                                }
                                pw.print("删除失败");
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
