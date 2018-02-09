package com.wsh.crm.course.service;

import com.wsh.crm.course.domain.CrmCourseType;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface CourseTypeService {

    void add(CrmCourseType crmCourseType);

    void update(CrmCourseType crmCourseType);

    void delete(CrmCourseType crmCourseType);

    List<CrmCourseType> findAll();

    CrmCourseType findByCourseTypeId(String courseTypeId);

    List<CrmCourseType> findByASP(String courseName, String remark, String totalStart, String totalEnd, String lessonCostStart, String lessonCostEnd);

    PageBean<CrmCourseType> findAll(int nowPageIndex, String courseName, String remark, String totalStart, String totalEnd, String lessonCostStart, String lessonCostEnd);
}
