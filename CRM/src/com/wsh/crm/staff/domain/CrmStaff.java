package com.wsh.crm.staff.domain;

import com.wsh.crm.post.domain.CrmPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
public class CrmStaff {
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Timestamp onDutyDate;
    @Autowired
    private CrmPost crmPost;

    @Override
    public String toString() {
        return "CrmStaff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", crmPost=" + crmPost +
                '}';
    }

    public CrmStaff(String staffId, String loginName, String loginPwd, String staffName, String gender, Timestamp onDutyDate, CrmPost crmPost) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.crmPost = crmPost;
    }

    public CrmStaff() {
    }

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Timestamp onDutyDate) {
        this.onDutyDate = onDutyDate;
    }


}
