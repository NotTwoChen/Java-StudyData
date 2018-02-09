package com.wsh.crm.department.domain;

import com.wsh.crm.post.domain.CrmPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CrmDepartment {
    private String depId;
    private String depName;
    @Autowired
    private Set<CrmPost> posts = new HashSet<>();

    @Override
    public String toString() {
        return "CrmDepartment{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    public CrmDepartment(String depId, String depName, Set<CrmPost> posts) {
        this.depId = depId;
        this.depName = depName;
        this.posts = posts;
    }

    public CrmDepartment() {

    }

    public Set<CrmPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<CrmPost> posts) {
        this.posts = posts;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmDepartment that = (CrmDepartment) o;

        if (depId != null ? !depId.equals(that.depId) : that.depId != null) return false;
        if (depName != null ? !depName.equals(that.depName) : that.depName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depId != null ? depId.hashCode() : 0;
        result = 31 * result + (depName != null ? depName.hashCode() : 0);
        return result;
    }
}
