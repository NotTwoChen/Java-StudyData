package com.wsh.order.domain;
/**
 *  entity class from database bookstore with table orders.
 *  Compiles all fields of a table into an entity class private property.
 *  And all attribute get/set methods are given.
 *  Create a constructor that has arguments and no arguments.
 *  Finally, the toString method is used to output the entity class attribute with String type.
 */
import java.sql.Timestamp;
import java.util.List;

public class Order {
    private String oid;
    private Timestamp ordertime;
    private float total;
    private int state;
    private String uid;
    private String address;
    private List<OrderItem> orderItemList;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                ", orderItemList=" + orderItemList +
                '}';
    }

    public Order() {
    }

    public Order(String oid, Timestamp ordertime, float total, int state, String uid, String address, List<OrderItem> orderItemList) {

        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.uid = uid;
        this.address = address;
        this.orderItemList = orderItemList;
    }

    public String getOid() {

        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
