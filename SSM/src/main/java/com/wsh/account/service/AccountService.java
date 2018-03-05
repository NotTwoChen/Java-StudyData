package com.wsh.account.service;

import com.wsh.account.domain.Account;
import com.wsh.account.service.util.AccountPageBean;

public interface AccountService {

    AccountPageBean queryAllByPage(int nowPageIndex,String recommenderId,String realName,String loginName,String status);

    void updateStatus(Account account);

    void addAccount(Account account);

    Account queryByAccountId(int account_id);

    void updateAccount(Account account);
}
