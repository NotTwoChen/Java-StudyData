package com.wsh.domain;

public class OrderDetail {

    private int id;
    private int orders_id;
    private int items_id;
    private int items_num;

    private Items items;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", items_id=" + items_id +
                ", items_num=" + items_num +
                ", items=" + items +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getItems_num() {
        return items_num;
    }

    public void setItems_num(int items_num) {
        this.items_num = items_num;
    }

    public OrderDetail() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }
}
