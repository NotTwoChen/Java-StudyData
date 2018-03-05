package com.wsh.account.service.util;

import com.wsh.account.domain.Account;
import com.wsh.util.PageBean;

public class AccountPageBean extends PageBean<Account> {

    private String idcardNo;
    private String realName;
    private String loginName;
    private String status;

    @Override
    public String toString() {
        return "AccountPageBean{" +
                "idcardNo='" + idcardNo + '\'' +
                ", realName='" + realName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public AccountPageBean(int nowPageIndex, int dataCount, String idcardNo, String realName, String loginName, String status) {
        super(nowPageIndex, dataCount);
        this.idcardNo = idcardNo;
        this.realName = realName;
        this.loginName = loginName;
        this.status = status;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public AccountPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
}
