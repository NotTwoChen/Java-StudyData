package com.wsh.order.dao;

import com.wsh.book.dao.BookDao;
import com.wsh.book.domain.Book;
import com.wsh.order.domain.Order;
import com.wsh.order.domain.OrderItem;
import com.wsh.util.PerfectQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private PerfectQueryRunner pqr = new PerfectQueryRunner();
    // 查找所有订单,并将订单内所有条目加载至order实体类实例化对象的List<OrderItem>属性集合中
    public List<Order> queryAll(){
        String sql = "SELECT * FROM orders WHERE state > 0 AND state < 5";
        List<Order> orderList = new ArrayList<>();
        try {
            orderList = pqr.query(sql, new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Order order : orderList) {
            List<OrderItem> orderItemList = queryByOidWithOrderItem(order.getOid());
            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }
    // 根据订单状态查找订单,并将订单内所有条目加载至对象属性集合中
    public List<Order> queryByState(int state){
        String sql = "SELECT * FROM orders WHERE state=?";
        List<Order> orderList = new ArrayList<>();
        try {
            orderList = pqr.query(sql, new BeanListHandler<Order>(Order.class), state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Order order : orderList) {
            List<OrderItem> orderItemList = queryByOidWithOrderItem(order.getOid());
            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }
    // 根据用户uid查询订单,并将订单内所有条目加载至对象属性集合中
    public List<Order> queryByUid(String uid){
        String sql = "SELECT * FROM orders WHERE uid=?";
        List<Order> orderList = new ArrayList<>();
        try {
            orderList = pqr.query(sql, new BeanListHandler<Order>(Order.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Order order : orderList) {
            List<OrderItem> orderItemList = queryByOidWithOrderItem(order.getOid());
            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }
    // 根据订单oid查找订单,并根据订单oid查找订单条目
    public Order queryByOidWithOrder(String oid){
        String sql = "SELECT * FROM orders WHERE oid=?";
        Order order = new Order();
        try {
            order = pqr.query(sql, new BeanHandler<Order>(Order.class), oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<OrderItem> orderItemList = queryByOidWithOrderItem(oid);
        order.setOrderItemList(orderItemList);
        return order;
    }
    // 根据订单oid查找订单条目,并将条目内所有书籍信息加载至对象属性对象中
    public List<OrderItem> queryByOidWithOrderItem(String oid){
        String sql = "SELECT * FROM orderitem WHERE oid=?";
        List<OrderItem> orderItemList = new ArrayList<>();
        try {
            orderItemList = pqr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (OrderItem orderItem : orderItemList) {
            Book book = new BookDao().queryByBid(orderItem.getBid());
            orderItem.setBook(book);
        }
        return orderItemList;
    }
    // 根据订单oid查找订单状态state
    public int queryByOidWithState(String oid){
        String sql = "SELECT state FROM orders WHERE oid=?";
        int state = 0;
        try {
            state = pqr.query(sql, new ScalarHandler<>(), oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }
    // 添加订单order到数据库中
    public int insertOrder(Order order){
        String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
        int update = 0;
        try {
            update = pqr.update(
                    sql,
                    order.getOid(),
                    order.getOrdertime(),
                    order.getTotal(),
                    order.getState(),
                    order.getUid(),
                    order.getAddress()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    // 运用批处理将OrderItemList添加订单条目到数据库中
    public void insertOrderItemList(List<OrderItem> orderItemList){
        String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
        Object[][] param = new Object[orderItemList.size()][];
        for (int i = 0; i < orderItemList.size(); i++) {
            OrderItem orderItem = orderItemList.get(i);
            param[i] = new Object[]{
                    orderItem.getIid(),
                    orderItem.getCount(),
                    orderItem.getSubtotal(),
                    orderItem.getOid(),
                    orderItem.getBid()
            };
        }
        try {
            pqr.batch(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 根据订单oid修改订单状态state
    public void updateState(String oid,int state){
        String sql = "update orders set state=? where oid=?";
        try {
            pqr.update(
                    "update orders set state=? where oid=?",
                    state,
                    oid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
