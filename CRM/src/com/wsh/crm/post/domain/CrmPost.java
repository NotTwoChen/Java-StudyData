package com.wsh.crm.post.domain;

import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.staff.domain.CrmStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CrmPost {
    private String postId;
    private String postName;
    @Autowired
    private Set<CrmStaff> crmStaffs = new HashSet<>();
    @Autowired
    private CrmDepartment crmDepartment;

    @Override
    public String toString() {
        return "CrmPost{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", crmDepartment=" + crmDepartment +
                '}';
    }

    public CrmPost(String postId, String postName, Set<CrmStaff> crmStaffs, CrmDepartment crmDepartment) {
        this.postId = postId;
        this.postName = postName;
        this.crmStaffs = crmStaffs;
        this.crmDepartment = crmDepartment;
    }

    public CrmPost() {

    }

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public Set<CrmStaff> getCrmStaffs() {
        return crmStaffs;
    }

    public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
        this.crmStaffs = crmStaffs;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

}
