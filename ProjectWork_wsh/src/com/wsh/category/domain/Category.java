package com.wsh.category.domain;
/**
 *  entity class from database bookstore with table category.
 *  Compiles all fields of a table into an entity class private property.
 *  And all attribute get/set methods are given.
 *  Create a constructor that has arguments and no arguments.
 *  Finally, the toString method is used to output the entity class attribute with String type.
 */
public class Category {
    private String cid;
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Category() {
    }

    public Category(String cid, String cname) {

        this.cid = cid;
        this.cname = cname;
    }

    public String getCid() {

        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
