package com.wsh.account.dao;

import com.wsh.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AccountMapper {

    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectAll(HashMap<String, Object> map);

    List<Account> selectAllByPage(HashMap<String, Object> map);

    void updateStatus(Account account);

    Account selectByIdcardNo(String idcardNo);
}