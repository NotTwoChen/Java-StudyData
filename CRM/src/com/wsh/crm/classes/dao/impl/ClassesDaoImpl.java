package com.wsh.crm.classes.dao.impl;

import com.wsh.crm.classes.dao.ClassesDao;
import com.wsh.crm.classes.domain.CrmClasses;
import com.wsh.crm.course.domain.CrmCourseType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classesDao")
public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

    @Override
    public List<CrmClasses> queryAll() {
        String sql = "from CrmClasses";
        List<?> classes = getHibernateTemplate().find(sql);
        return (List<CrmClasses>) classes;
    }

    @Override
    public CrmClasses queryByClassId(String classId) {
        return getHibernateTemplate().get(CrmClasses.class,classId);
    }

    @Override
    public void insertOrUpdate(CrmClasses crmClasses) {
        if (!crmClasses.getClassId().equals("")) {
            CrmClasses newCrmClasses = getHibernateTemplate().get(CrmClasses.class, crmClasses.getClassId());
            CrmCourseType crmCourseType = getHibernateTemplate().get(CrmCourseType.class, crmClasses.getCrmCourseType().getCourseTypeId());
            newCrmClasses.setName(crmClasses.getName());
            newCrmClasses.setCrmCourseType(crmCourseType);
            newCrmClasses.setBeginTime(crmClasses.getBeginTime());
            newCrmClasses.setEndTime(crmClasses.getEndTime());
            newCrmClasses.setRemark(crmClasses.getRemark());
            getHibernateTemplate().update(newCrmClasses);
        }else {
            CrmCourseType crmCourseType = getHibernateTemplate().get(CrmCourseType.class, crmClasses.getCrmCourseType().getCourseTypeId());
            crmClasses.setCrmCourseType(crmCourseType);
            crmClasses.setStatus("1");
            getHibernateTemplate().save(crmClasses);
        }
    }

    @Override
    public void updateUpload(CrmClasses crmClasses) {
        getHibernateTemplate().update(crmClasses);
    }
}
