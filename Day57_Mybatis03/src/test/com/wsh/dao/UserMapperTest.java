package com.wsh.dao;

import com.wsh.domain.Items;
import com.wsh.domain.OrderDetail;
import com.wsh.domain.Orders;
import com.wsh.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {


    private UserMapper userMapper;
    private SqlSession sqlSession;
    private OrdersMapper ordersMapper;

    @Before
    public void setUp()throws Exception{
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml")).openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectUsers() throws Exception {
        List<User> users = userMapper.selectUsers();
        for (User user : users) {
            System.out.println("--"+user);
            List<Orders> ordersList = user.getOrdersList();
            for (Orders orders : ordersList) {
                System.out.println("------" + orders);
                List<OrderDetail> orderDetailList = orders.getOrderDetailList();
                for (OrderDetail orderDetail : orderDetailList) {
                    System.out.println("----------" + orderDetail);
                    Items items = orderDetail.getItems();
                    System.out.println("----------------" + items);
                }
            }
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("任宏宇");
        userMapper.insert(user);
        sqlSession.commit();

        Orders orders1 = new Orders();
        Orders orders2 = new Orders();
        Orders orders3 = new Orders();
        orders1.setNumber("1110");
        orders2.setNumber("1111");
        orders3.setNumber("1112");
        orders1.setUserId(user.getId());
        orders2.setUserId(user.getId());
        orders3.setUserId(user.getId());
        ordersMapper.insert(orders1);
        ordersMapper.insert(orders2);
        ordersMapper.insert(orders3);
        sqlSession.commit();

        List<Orders> ordersList = new ArrayList<>();
        ordersList.add(orders1);
        ordersList.add(orders2);
        ordersList.add(orders3);
        user.setOrdersList(ordersList);


        System.out.println(user);

    }

    @Test
    public void name() throws Exception {
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper4 = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper1);
        System.out.println(userMapper2);
        System.out.println(userMapper3);
        System.out.println(userMapper4);
    }
}