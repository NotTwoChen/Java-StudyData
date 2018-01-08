package com.wsh.project.bean;

public class Classify {
    private int cid;
    private String classname;

    @Override
    public String toString() {
        return "Classify{" +
                "cid=" + cid +
                ", classname='" + classname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Classify(int cid, String classname) {

        this.cid = cid;
        this.classname = classname;
    }

    public Classify() {

    }
}
