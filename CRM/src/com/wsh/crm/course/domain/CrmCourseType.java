package com.wsh.crm.course.domain;

import com.wsh.crm.classes.domain.CrmClasses;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CrmCourseType {
    private String courseTypeId;
    private Double courseCost;
    private Integer total;
    private String courseName;
    private String remark;
    @Autowired
    private Set<CrmClasses> crmClasses = new HashSet<>();

    public Set<CrmClasses> getCrmClasses() {
        return crmClasses;
    }

    public void setCrmClasses(Set<CrmClasses> crmClasses) {
        this.crmClasses = crmClasses;
    }

    @Override
    public String toString() {
        return "CrmCourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public CrmCourseType(String courseTypeId, Double courseCost, Integer total, String courseName, String remark) {
        this.courseTypeId = courseTypeId;
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public CrmCourseType() {

    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmCourseType that = (CrmCourseType) o;

        if (courseTypeId != null ? !courseTypeId.equals(that.courseTypeId) : that.courseTypeId != null) return false;
        if (courseCost != null ? !courseCost.equals(that.courseCost) : that.courseCost != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseTypeId != null ? courseTypeId.hashCode() : 0;
        result = 31 * result + (courseCost != null ? courseCost.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
