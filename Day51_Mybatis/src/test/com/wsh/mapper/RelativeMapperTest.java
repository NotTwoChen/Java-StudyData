package com.wsh.mapper;

import com.wsh.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RelativeMapperTest {

    private SqlSession sqlSession;
    private OrdersMapper ordersMapper;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    }

    @Test
    public void findOrdersUser() throws Exception {
        List<OrdersExt> ordersUser = ordersMapper.findOrdersUser();
        for (OrdersExt ordersExt : ordersUser) {
            System.out.println(ordersExt);
        }
    }

    @Test
    public void findOrdersUserRstMap() throws Exception {
        List<Orders> userRstMap = ordersMapper.findOrdersUserRstMap();
        for (Orders orders : userRstMap) {
            System.out.println(orders);
            System.out.println(orders.getUser());
        }
    }

    @Test
    public void findOrdersAndOrderDetailRstMap() throws Exception {
        List<Orders> list = ordersMapper.findOrdersAndOrderDetailRstMap();
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }

    @Test
    public void findUserAndItemsRstMap() throws Exception {
        List<User> userList = ordersMapper.findUserAndItemsRstMap();
        for (User user : userList) {
            System.out.println("-"+user.getUsername()+"的信息");
            List<Orders> ordersList = user.getOrdersList();
            for (Orders orders : ordersList) {
                System.out.println("---"+orders);
                List<OrderDetail> detailList = orders.getDetailList();
                for (OrderDetail orderDetail : detailList) {
                    System.out.println("-----"+orderDetail);
                    Items items = orderDetail.getItems();
                    System.out.println("-------"+items);
                }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

}