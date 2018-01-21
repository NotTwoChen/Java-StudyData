package com.wsh.work.bean;

import java.sql.Date;

public class Staff {
    private int sid;
    private String name;
    private Integer age;
    private String branch;
    private Date hiredate;
    private String address;
    private String telephone;

    @Override
    public String toString() {
        return "Staff{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", branch='" + branch + '\'' +
                ", hiredate=" + hiredate +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Staff(String name, Integer age, String branch, Date hiredate, String address, String telephone) {
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.hiredate = hiredate;
        this.address = address;
        this.telephone = telephone;
    }

    public Staff() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (sid != staff.sid) return false;
        if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
        if (age != null ? !age.equals(staff.age) : staff.age != null) return false;
        if (branch != null ? !branch.equals(staff.branch) : staff.branch != null) return false;
        if (hiredate != null ? !hiredate.equals(staff.hiredate) : staff.hiredate != null) return false;
        if (address != null ? !address.equals(staff.address) : staff.address != null) return false;
        if (telephone != null ? !telephone.equals(staff.telephone) : staff.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
