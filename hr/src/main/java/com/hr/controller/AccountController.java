package com.hr.controller;

import com.hr.model.Account;
import com.hr.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("gologin")
    public String gologin() throws Exception{
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
        System.out.println(account);
        Account account1 = accountService.getAccount(account);
        System.out.println(account1);
        if (account1!=null){
            session.setAttribute("user",account1);
            switch (account1.getType()){
                case "visitor":
                    return "";
                case "employee":
                    return "";
                case "admin":
                    return "admin/adminMain";
            }

        }
        return "../../index";
    }
}
