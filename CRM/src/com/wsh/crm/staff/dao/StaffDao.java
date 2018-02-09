package com.wsh.crm.staff.dao;

import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.util.PageBean;

import java.util.List;

/**
 * 员工Dao层
 */
public interface StaffDao {

    void insert(CrmStaff staff);

    void delete(CrmStaff staff);

    void update(CrmStaff staff);

    /**
     *  登录  通过账号和密码查询
     * @param loginName 账号
     * @param loginPwd  密码
     * @return  返回一个员工对象
     */
    CrmStaff query(String loginName, String loginPwd);

    CrmStaff queryByLoginName(String loginName);

    CrmStaff queryByStaffId(String staffId);

    List<CrmStaff> queryAll();

    List<CrmStaff> queryAll(String hql,PageBean pageBean);

    List<CrmStaff> queryAll(String sql);

}
