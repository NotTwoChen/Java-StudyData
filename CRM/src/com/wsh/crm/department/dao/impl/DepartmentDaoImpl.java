package com.wsh.crm.department.dao.impl;

import com.wsh.crm.department.dao.DepartmentDao;
import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.util.PageBean;
import com.wsh.crm.util.PageUtil;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {


    @Override
    public List<CrmDepartment> queryAll() {
        List<CrmDepartment> departments = (List<CrmDepartment>) getHibernateTemplate().find("from CrmDepartment ");
        return departments;
    }

    @Override
    public CrmDepartment queryByDepId(String depId) {
        return getHibernateTemplate().get(CrmDepartment.class,depId);
    }

    @Override
    public void update(CrmDepartment crmDepartment) {
        CrmDepartment crmDepartment1 = queryByDepId(crmDepartment.getDepId());
        crmDepartment1.setDepName(crmDepartment.getDepName());
        getHibernateTemplate().update(crmDepartment1);
    }

    @Override
    public void insert(CrmDepartment crmDepartment) {
        crmDepartment.setPosts(null);
        getHibernateTemplate().save(crmDepartment);
    }

    @Override
    public List<CrmDepartment> queryAll(PageBean<CrmDepartment> pageBean) {
        String hql = "from CrmDepartment";
        return getHibernateTemplate().execute(session -> {
            return PageUtil.query(session,hql,pageBean);
        });
    }
}
