package com.hr.controller;

import com.hr.service.AccountService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class VisitorController {
    @Resource
    private AccountService accountService;


}
