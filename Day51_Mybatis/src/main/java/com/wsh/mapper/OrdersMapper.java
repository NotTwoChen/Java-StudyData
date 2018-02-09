package com.wsh.mapper;

import com.wsh.domain.Orders;
import com.wsh.domain.OrdersExt;
import com.wsh.domain.User;

import java.util.List;

public interface OrdersMapper {

    List<OrdersExt> findOrdersUser();

    List<Orders> findOrdersUserRstMap();

    List<Orders> findOrdersAndOrderDetailRstMap();

    List<User> findUserAndItemsRstMap();
}
