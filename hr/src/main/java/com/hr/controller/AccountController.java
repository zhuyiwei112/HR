package com.hr.controller;

import com.hr.model.Account;
import com.hr.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("goregister")
    public String goRegister() throws Exception{
        return "register";
    }

    @RequestMapping("register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        PrintWriter pw = response.getWriter();
        if (name==null||name.equals("")){
            pw.print("账号不能为空");
            return;
        }
        if (pass==null||pass.equals("")){
            pw.print("密码不能为空");
            return;
        }
        if (repass==null||repass.equals("")){
            pw.print("确认密码不能为空");
            return;
        }
        String reg1="^[A-z][A-z0-9_]{4,15}$";
        String reg2="^[A-z]\\w{5,17}$";
        if (!Pattern.matches(reg1,name)){
            pw.print("用户名不合法");
        }else if(!Pattern.matches(reg2,pass)) {
            pw.print("密码不合法");
        }else{
            Account account = new Account(name,pass,"visitor");
            int i = accountService.addAccount(account);
            if (i==0){
                pw.print("用户存在");
                return;
            }
            if (i==1){
                pw.print("注册成功");
                return;
            }
            if (i==2){
                pw.print("注册失败");
                return;
            }
        }

    }

    @RequestMapping("gologin")
    public String goLogin() throws Exception{
        return "login";
    }

    @RequestMapping("login")
    public String login (HttpSession session, HttpServletRequest request) throws Exception{
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String type = request.getParameter("type");
        switch (type){
            case "游客":
                type="visitor";
                break;
            case "员工":
                type="employee";
                break;
            case "管理员":
                type="admin";
                break;
        }
        Account account = new Account(name,pass,type);
        //System.out.println(account);
        Account account1 = accountService.getAccount(account);
        //System.out.println(account1);
        if (account1!=null){
            //System.out.println("acc:"+account1);
            session.setAttribute("user",account1);
            switch (account1.getType()){
                case "visitor":
                    return "getrcinfo";
                case "employee":
                    return "employee/signin";
                case "admin":
                    return "admin/adminMain";
            }

        }
        return "login";
    }
}
