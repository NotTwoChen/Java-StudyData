package com.wsh.crm.course.service.impl;

import com.wsh.crm.course.dao.CourseTypeDao;
import com.wsh.crm.course.domain.CrmCourseType;
import com.wsh.crm.course.service.CourseTypeService;
import com.wsh.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeDao courseTypeDao;
    private PageBean<CrmCourseType> pageBean;

    @Override
    public void add(CrmCourseType crmCourseType) {
        courseTypeDao.add(crmCourseType);
    }

    @Override
    public void update(CrmCourseType crmCourseType) {
        courseTypeDao.update(crmCourseType);
    }

    @Override
    public void delete(CrmCourseType crmCourseType) {
        courseTypeDao.delete(crmCourseType);
    }

    @Override
    public List<CrmCourseType> findAll() {
        String hql = "from CrmCourseType";
        return courseTypeDao.queryAll(hql);
    }

    @Override
    public CrmCourseType findByCourseTypeId(String courseTypeId) {
        return courseTypeDao.queryByCourseTypeId(courseTypeId);
    }

    @Override
    public List<CrmCourseType> findByASP(String courseName, String remark, String totalStart, String totalEnd, String lessonCostStart, String lessonCostEnd) {
        StringBuilder sb = new StringBuilder("from CrmCourseType ct where 1=1 ");
        if (!courseName.equals("")){
            sb.append(" and ct.courseName ='" + courseName + "' ");
        }
        if (!remark.equals("")){
            sb.append(" and ct.remark like '%" + remark + "%' ");
        }
        if (!totalStart.equals("")&&!totalEnd.equals("")){
            sb.append(" and ct.total between '" + totalStart + "' and '" + totalEnd + "' ");
        }
        if (!lessonCostStart.equals("")&&!lessonCostEnd.equals("")){
            sb.append(" and ct.courseCost between '" + lessonCostStart + "' and '" + lessonCostEnd + "' ");
        }
        return courseTypeDao.queryByASP(sb.toString());
    }

    @Override
    public PageBean<CrmCourseType> findAll(int nowPageIndex, String courseName, String remark, String totalStart, String totalEnd, String lessonCostStart, String lessonCostEnd) {
        StringBuilder sb = new StringBuilder("from CrmCourseType ct where 1=1 ");
        if (!courseName.equals("")){
            sb.append(" and ct.courseName ='" + courseName + "' ");
        }
        if (!remark.equals("")){
            sb.append(" and ct.remark like '%" + remark + "%' ");
        }
        if (!totalStart.equals("")&&!totalEnd.equals("")){
            sb.append(" and ct.total between '" + totalStart + "' and '" + totalEnd + "' ");
        }else if (!totalStart.equals("")){
            sb.append(" and ct.total > '" + totalStart + "' ");
        }else if (!totalEnd.equals("")){
            sb.append(" and ct.total < '" + totalEnd + "' ");
        }
        if (!lessonCostStart.equals("")&&!lessonCostEnd.equals("")){
            sb.append(" and ct.courseCost between '" + lessonCostStart + "' and '" + lessonCostEnd + "' ");
        }else if (!lessonCostStart.equals("")){
            sb.append(" and ct.courseCost > '" + lessonCostStart + "' ");
        }else if (!lessonCostEnd.equals("")){
            sb.append(" and ct.courseCost < '" + lessonCostEnd + "' ");
        }
        List<CrmCourseType> crmCourseTypes = courseTypeDao.queryAll(sb.toString());
        pageBean = new PageBean<>(nowPageIndex,crmCourseTypes.size());
        crmCourseTypes = courseTypeDao.queryAll(sb.toString(),pageBean);
        pageBean.setList(crmCourseTypes);
        return pageBean;
    }

    public PageBean<CrmCourseType> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<CrmCourseType> pageBean) {
        this.pageBean = pageBean;
    }

    public CourseTypeDao getCourseTypeDao() {
        return courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }
}
