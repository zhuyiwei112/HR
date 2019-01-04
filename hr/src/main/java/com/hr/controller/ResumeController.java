package com.hr.controller;

import com.hr.model.Account;
import com.hr.model.Resume;
import com.hr.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    //去登入
    @RequestMapping
    public String goLogin(){
        return "login";
    }

    //删除简历
    @RequestMapping("delRS")
    public void delRS(Resume resume,HttpSession session,HttpServletResponse response) throws Exception{
        PrintWriter pw=response.getWriter();
        //System.out.println("传值："+resume);
        if (resumeService.delRS(resume)){
            pw.print("删除成功");
            Account user = (Account) session.getAttribute("user");
            Resume resume1 = resumeService.getRS(new Resume(user));
            //System.out.println("查询："+resume1);
            session.setAttribute("resume1",resume1);
        }else {
            pw.print("删除失败");
        }
    }

    //修改简历
    @RequestMapping("updateRS")
    public void updateRS(HttpSession session,Resume resume,HttpServletResponse response) throws Exception{
        PrintWriter pw=response.getWriter();
        if (resume.getName()==null||"".equals(resume.getName())){
            pw.print("姓名不能为空");
            return;
        }
        if(resume.getSex()==null||"".equals(resume.getSex())){
            pw.print("性别不能为空");
            return;
        }
        if (resume.getBirth()==null||"".equals(resume.getBirth())){
            pw.print("出生年月不能为空");
            return;
        }
        if (resume.getPhone()==null||"".equals(resume.getPhone())){
            pw.print("手机号不能为空");
            return;
        }
        if(resume.getEducation()==null||"".equals(resume.getEducation())){
            pw.print("学历不能为空");
            return;
        }
        if(resume.getMajor()==null||"".equals(resume.getMajor())){
            pw.print("专业不能为空");
            return;
        }
        if(resume.getEmail()==null||"".equals(resume.getEmail())){
            pw.print("邮箱不能为空");
            return;
        }
        if(resume.getAddress()==null||"".equals(resume.getAddress())){
            pw.print("联系地址不能为空");
            return;
        }
        if(resume.getExperience()==null||"".equals(resume.getExperience())){
            pw.print("工作经验不能为空");
            return;
        }

        Account user = (Account) session.getAttribute("user");
        resume.setAccount(user);
        Resume resume1 = resumeService.getRS(resume);
        resume.setId(resume1.getId());
        if (resumeService.updateRS(resume)){
            pw.print("修改成功");
            session.setAttribute("resume",resume1);
        }else{
            pw.print("修改失败");
        }
    }

    //跳转修改简历
    @RequestMapping("goUpdateRS")
    public String goUpdateRS(HttpSession session) throws Exception{
        return "visitor/updateRS";
    }

    //增加简历
    @RequestMapping("addRS")
    public void addRS(Resume resume, HttpSession session, HttpServletResponse response) throws Exception {
        //System.out.println(resume);

        PrintWriter pw=response.getWriter();
        if (resume.getName()==null||"".equals(resume.getName())){
            pw.print("姓名不能为空");
            return;
        }
        if(resume.getSex()==null||"".equals(resume.getSex())){
            pw.print("性别不能为空");
            return;
        }
        if (resume.getBirth()==null||"".equals(resume.getBirth())){
            pw.print("出生年月不能为空");
            return;
        }
        if (resume.getPhone()==null||"".equals(resume.getPhone())){
            pw.print("手机号不能为空");
            return;
        }
        if(resume.getEducation()==null||"".equals(resume.getEducation())){
            pw.print("学历不能为空");
            return;
        }
        if(resume.getMajor()==null||"".equals(resume.getMajor())){
            pw.print("专业不能为空");
            return;
        }
        if(resume.getEmail()==null||"".equals(resume.getEmail())){
            pw.print("邮箱不能为空");
            return;
        }
        if(resume.getAddress()==null||"".equals(resume.getAddress())){
            pw.print("联系地址不能为空");
            return;
        }
        if(resume.getExperience()==null||"".equals(resume.getExperience())){
            pw.print("工作经验不能为空");
            return;
        }

        Account user = (Account) session.getAttribute("user");
        resume.setAccount(user);
        if (resumeService.addRS(resume)){
            //System.out.println("add：true");
            pw.print("保存成功");
        }else {
            pw.print("保存失败");
        }
    }

    //查询简历
    @RequestMapping("getRS")
    public String getRS(HttpSession session) throws Exception {
        Account user = (Account) session.getAttribute("user");
        //System.out.println("rsuser:"+user);
        if (user == null) {
            return "login";
        }
        Resume resume = resumeService.getRS(new Resume(user));
        //System.out.println("登入后简历"+resume);
        session.setAttribute("resume",resume);
        return "visitor/getResume";
    }
}
