package com.wsh.domain;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private String number;

    private Integer userId;

    private Date createtime;

    private String note;

    private List<OrderDetail> orderDetailList;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userId=" + userId +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", orderDetailList=" + orderDetailList +
                '}';
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Orders(Integer id, String number, Integer userId, Date createtime, String note) {
        this.id = id;
        this.number = number;
        this.userId = userId;
        this.createtime = createtime;
        this.note = note;
    }

    public Orders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}