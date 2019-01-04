package com.hr.dao;

import com.hr.model.Account;

public interface AccountDao {
    Account getAccount(Account account);
    boolean addAccount(Account account);
    boolean updateAccount(Account account);
    Account getAccountByName(String name);
}
