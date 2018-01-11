package com.wsh.admin.web;

import com.wsh.order.domain.Order;
import com.wsh.order.service.OrderService;
import com.wsh.user.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "AdminOrderServlet",urlPatterns = "/adminOrder")
public class AdminOrderServlet extends BaseServlet {
    private OrderService os = new OrderService();

    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Order> orderList = os.findAll();
        request.setAttribute("orderList",orderList);
        return "f:/adminjsps/admin/order/list.jsp";
    }
    public String state(HttpServletRequest request, HttpServletResponse response){
        int state = Integer.parseInt(request.getParameter("state"));
        List<Order> orderList = os.queryByState(state);
        request.setAttribute("orderList",orderList);
        return "f:/adminjsps/admin/order/list.jsp";
    }
    public String changeState(HttpServletRequest request, HttpServletResponse response){
        int state = Integer.parseInt(request.getParameter("state"));
        String oid = request.getParameter("oid");
        state++;
        os.changeState(oid,state);
        return findAll(request,response);
    }

}
