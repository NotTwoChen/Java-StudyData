package com.wsh.crm.department.service.impl;

import com.wsh.crm.department.dao.DepartmentDao;
import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.department.service.DepartmentService;
import com.wsh.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    private PageBean<CrmDepartment> pageBean;
    @Override
    public List<CrmDepartment> queryAll() {
        return departmentDao.queryAll();
    }

    @Override
    public CrmDepartment queryByDepId(String depId) {
        return departmentDao.queryByDepId(depId);
    }

    @Override
    public void update(CrmDepartment crmDepartment) {
        departmentDao.update(crmDepartment);
    }

    @Override
    public void add(CrmDepartment crmDepartment) {
        departmentDao.insert(crmDepartment);
    }

    @Override
    public PageBean<CrmDepartment> queryAll(int nowPageIndex) {
        pageBean = new PageBean<>(nowPageIndex,queryAll().size());
        List<CrmDepartment> crmDepartments = departmentDao.queryAll(pageBean);
        pageBean.setList(crmDepartments);
        return pageBean;
    }

    public PageBean<CrmDepartment> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<CrmDepartment> pageBean) {
        this.pageBean = pageBean;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
