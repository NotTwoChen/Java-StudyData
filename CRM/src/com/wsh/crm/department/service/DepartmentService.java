package com.wsh.crm.department.service;

import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface DepartmentService {

    List<CrmDepartment> queryAll();

    CrmDepartment queryByDepId(String depId);

    void update(CrmDepartment crmDepartment);

    void add(CrmDepartment crmDepartment);

    PageBean<CrmDepartment> queryAll(int nowPageIndex);
}
