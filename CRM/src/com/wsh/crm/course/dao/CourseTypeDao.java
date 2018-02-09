package com.wsh.crm.course.dao;

import com.wsh.crm.course.domain.CrmCourseType;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface CourseTypeDao {

    void add(CrmCourseType crmCourseType);

    void update(CrmCourseType crmCourseType);

    void delete(CrmCourseType crmCourseType);

    List<CrmCourseType> queryAll(String hql);

    CrmCourseType queryByCourseTypeId(String courseTypeId);

    List<CrmCourseType> queryByASP(String sql);

    List<CrmCourseType> queryAll(String hql, PageBean<CrmCourseType> pageBean);
}
