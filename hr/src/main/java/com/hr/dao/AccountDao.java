package com.hr.dao;

import com.hr.model.Account;

public interface AccountDao {
    Account getAccount(Account account);
    boolean addAccount(Account account);
    Account getAccountByName(String name);
}
