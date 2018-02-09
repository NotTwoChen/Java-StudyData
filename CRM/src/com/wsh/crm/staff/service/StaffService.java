package com.wsh.crm.staff.service;

import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.staff.service.exception.NameOrPwdErrorException;
import com.wsh.crm.util.PageBean;

import java.util.List;

/**
 * 员工的service
 */
public interface StaffService {

    /**
     *  登录
     * @param crmStaff  包含账号和密码的员工对象
     * @return  返回一个员工对象
     * @throws NameOrPwdErrorException
     */
    CrmStaff login(CrmStaff crmStaff) throws NameOrPwdErrorException;

    CrmStaff queryByStaffId(String staffId);

    void editPassword(CrmStaff staff,String newPassword);

    void updateStaff(CrmStaff crmStaff);

    PageBean<CrmStaff> queryAll(int nowPageIndex,String depId, String postId, String staffName);

    void insert(CrmStaff crmStaff);

    PageBean<CrmStaff> getPageBean();
}
