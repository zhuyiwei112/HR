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

    @Override
    public int addAccount(Account account) {
        if (account==null){
            return -1;
        }
        Account account1 = accountDao.getAccountByName(account.getName());
        if (account1==null){
             if(accountDao.addAccount(account)){
                 return 1;//成功
             }
             return 2;//失败
        }
        return 0;//用户存在
    }
}
