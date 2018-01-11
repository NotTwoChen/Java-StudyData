package com.wsh.order.service;

import com.wsh.order.dao.OrderDao;
import com.wsh.order.domain.Order;
import com.wsh.order.domain.OrderItem;
import com.wsh.order.service.exception.OrderException;

import java.util.List;

public class OrderService {
    private OrderDao od = new OrderDao();
    // 添加订单
    public void addOrder(Order order){
        od.insertOrder(order);
    }
    // 添加订单条目
    public void addOrderItem(List<OrderItem> orderItemList){
        od.insertOrderItemList(orderItemList);
    }
    // 查找所有订单
    public List<Order> findAll(){
        return od.queryAll();
    }
    // 根据参数uid查询订单
    public List<Order> queryByUid(String uid){
        return od.queryByUid(uid);
    }
    // 根据参数state查询订单
    public List<Order> queryByState(int state){
        return od.queryByState(state);
    }
    // 根据参数oid查询订单
    public Order load(String oid){
        return od.queryByOidWithOrder(oid);
    }
    // 判断state是否为3,如果是,则更改为4,如果不是,抛出异常
    public void confirm(String oid) throws OrderException {
        int state = od.queryByOidWithState(oid);
        if (state == 3){
            od.updateState(oid,4);
        }else {
            throw new OrderException();
        }
    }
    // 根据参数oid更改数据库state
    public void changeState(String oid,int state){
        od.updateState(oid,state);
    }
}
