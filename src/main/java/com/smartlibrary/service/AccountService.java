package com.smartlibrary.service;

import com.smartlibrary.dao2.AccountDao;
import com.smartlibrary.domain2.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zian on 2017/9/24.
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public Account getAccount(Account account) {
        Account account1 = accountDao.getAccountByAP(account);
        return account1;
    }
}
