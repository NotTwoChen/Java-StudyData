package com.wsh.crm.classes.domain;

import com.wsh.crm.course.domain.CrmCourseType;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class CrmClasses {
    private String classId;
    private String name;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String status;
    private Integer totalCount;
    private Integer upgradeCount;
    private Integer changeCount;
    private Integer runoffCount;
    private String remark;
    private Timestamp uploadTime;
    private String uploadPath;
    private String uploadFilename;
    @Autowired
    private CrmCourseType crmCourseType;

    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }

    @Override
    public String toString() {
        return "CrmClasses{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                ", crmCourseType=" + crmCourseType +
                '}';
    }

    public CrmClasses(String classId, String name, Timestamp beginTime, Timestamp endTime, String status, Integer totalCount, Integer upgradeCount, Integer changeCount, Integer runoffCount, String remark, Timestamp uploadTime, String uploadPath, String uploadFilename) {
        this.classId = classId;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.uploadPath = uploadPath;
        this.uploadFilename = uploadFilename;
    }

    public CrmClasses() {

    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmClasses that = (CrmClasses) o;

        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (totalCount != null ? !totalCount.equals(that.totalCount) : that.totalCount != null) return false;
        if (upgradeCount != null ? !upgradeCount.equals(that.upgradeCount) : that.upgradeCount != null) return false;
        if (changeCount != null ? !changeCount.equals(that.changeCount) : that.changeCount != null) return false;
        if (runoffCount != null ? !runoffCount.equals(that.runoffCount) : that.runoffCount != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (uploadPath != null ? !uploadPath.equals(that.uploadPath) : that.uploadPath != null) return false;
        if (uploadFilename != null ? !uploadFilename.equals(that.uploadFilename) : that.uploadFilename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId != null ? classId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalCount != null ? totalCount.hashCode() : 0);
        result = 31 * result + (upgradeCount != null ? upgradeCount.hashCode() : 0);
        result = 31 * result + (changeCount != null ? changeCount.hashCode() : 0);
        result = 31 * result + (runoffCount != null ? runoffCount.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (uploadPath != null ? uploadPath.hashCode() : 0);
        result = 31 * result + (uploadFilename != null ? uploadFilename.hashCode() : 0);
        return result;
    }
}
