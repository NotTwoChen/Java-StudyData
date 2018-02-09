package com.wsh.crm.course.dao.impl;

import com.wsh.crm.course.dao.CourseTypeDao;
import com.wsh.crm.course.domain.CrmCourseType;
import com.wsh.crm.util.PageBean;
import com.wsh.crm.util.PageUtil;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("courseTypeDao")
public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

    @Override
    public void add(CrmCourseType crmCourseType) {
        getHibernateTemplate().save(crmCourseType);
    }

    @Override
    public void update(CrmCourseType crmCourseType) {
        getHibernateTemplate().update(crmCourseType);
    }

    @Override
    public void delete(CrmCourseType crmCourseType) {
        getHibernateTemplate().delete(crmCourseType);
    }

    @Override
    public List<CrmCourseType> queryAll(String hql) {
        List<CrmCourseType> crmCourseTypes = (List<CrmCourseType>) getHibernateTemplate().find(hql);
        return crmCourseTypes;
    }

    @Override
    public CrmCourseType queryByCourseTypeId(String courseTypeId) {
        return getHibernateTemplate().get(CrmCourseType.class,courseTypeId);
    }

    @Override
    public List<CrmCourseType> queryByASP(String sql) {
        return (List<CrmCourseType>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<CrmCourseType> queryAll(String hql, PageBean<CrmCourseType> pageBean) {
        return getHibernateTemplate().execute(session -> {
            return PageUtil.query(session,hql,pageBean);
        });
    }
}
