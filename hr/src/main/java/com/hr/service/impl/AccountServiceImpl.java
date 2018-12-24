package com.hr.service.impl;

import com.hr.dao.AccountDao;
import com.hr.model.Account;
import com.hr.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public Account getAccount(Account account) {
        if (account!=null){
            return accountDao.getAccount(account);
        }
        return null;
    }
}
