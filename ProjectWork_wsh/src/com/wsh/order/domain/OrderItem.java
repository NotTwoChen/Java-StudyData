package com.wsh.order.domain;
/**
 *  entity class from database bookstore with table orderitem.
 *  Compiles all fields of a table into an entity class private property.
 *  And all attribute get/set methods are given.
 *  Create a constructor that has arguments and no arguments.
 *  Finally, the toString method is used to output the entity class attribute with String type.
 */
import com.wsh.book.domain.Book;

import java.math.BigDecimal;

public class OrderItem {

    private String iid;
    private int count;
    private float subtotal;
    private String oid;
    private String bid;
    private Book book;

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid='" + iid + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                ", book=" + book +
                '}';
    }

    public OrderItem() {
    }

    public OrderItem(String iid, int count, float subtotal, String oid, String bid, Book book) {

        this.iid = iid;
        this.count = count;
        this.subtotal = subtotal;
        this.oid = oid;
        this.bid = bid;
        this.book = book;
    }

    public String getIid() {

        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
