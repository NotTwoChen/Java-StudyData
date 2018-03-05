package com.wsh.account.service.impl;

import com.wsh.account.dao.AccountMapper;
import com.wsh.account.domain.Account;
import com.wsh.account.service.AccountService;
import com.wsh.account.service.util.AccountPageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    private AccountPageBean pageBean;


    @Override
    public AccountPageBean queryAllByPage(int nowPageIndex,String idcardNo,String realName,String loginName,String status) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("idcardNo",idcardNo);
        map.put("realName",realName);
        map.put("loginName",loginName);
        map.put("status",status);
        List<Account> accounts = accountMapper.selectAll(map);
        pageBean = new AccountPageBean(nowPageIndex, accounts.size(),idcardNo,realName,loginName,status);
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        accounts = accountMapper.selectAllByPage(map);
        pageBean.setList(accounts);
        return pageBean;
    }

    @Override
    public void updateStatus(Account account) {
        accountMapper.updateStatus(account);
    }

    @Override
    public void addAccount(Account account) {
        account.setStatus("1");
        account.setCreateDate(new Timestamp(System.currentTimeMillis()));
        accountMapper.insertSelective(account);
    }

    @Override
    public Account queryByAccountId(int account_id) {
        Account account = accountMapper.selectByPrimaryKey(account_id);
        if (account.getRecommenderId() != null){
            Account recommender = accountMapper.selectByPrimaryKey(account.getRecommenderId());
            account.setRecommenderAccount(recommender);
        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateByPrimaryKeySelective(account);
    }
}
