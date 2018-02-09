package com.wsh.crm.department.dao;

import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface DepartmentDao {

    List<CrmDepartment> queryAll();

    CrmDepartment queryByDepId(String depId);

    void update(CrmDepartment crmDepartment);

    void insert(CrmDepartment crmDepartment);

    List<CrmDepartment> queryAll(PageBean<CrmDepartment> pageBean);
}
