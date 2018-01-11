package com.wsh.order.web;

import com.wsh.book.service.BookService;
import com.wsh.cart.domain.Cart;
import com.wsh.cart.domain.CartItem;
import com.wsh.order.domain.Order;
import com.wsh.order.domain.OrderItem;
import com.wsh.order.service.OrderService;
import com.wsh.order.service.exception.OrderException;
import com.wsh.user.domain.User;
import com.wsh.user.web.BaseServlet;
import com.wsh.util.GetUUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
    private OrderService os = new OrderService();
    // 详情见方法体注释内容(添加订单内容)
    public String add(HttpServletRequest request, HttpServletResponse response){
        // 在session域中得到用户的购物车cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 创建订单对象
        Order order = new Order();
        // set订单oid
        order.setOid(new GetUUID().getUUID());
        // 通过购物车得到购物条目的Map集合
        Map<String, CartItem> cartItemMap = cart.getCart();
        // 创建存储订单条目的List集合
        List<OrderItem> orderItemList = new ArrayList<>();
        // 遍历Map集合
        for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
            // 创建订单条目对象
            OrderItem orderItem = new OrderItem();
            // set订单条目所有属性
            orderItem.setIid(new GetUUID().getUUID());// iid
            orderItem.setOid(order.getOid());// oid
            orderItem.setBid(entry.getKey());// bid
            orderItem.setCount(entry.getValue().getCount()); // count
            orderItem.setSubtotal(entry.getValue().getCount()*entry.getValue().getBook().getPrice());// subtotal
            orderItem.setBook(new BookService().queryByBid(orderItem.getBid()));// book
            // 将创建后的订单条目对象放进List集合中
            orderItemList.add(orderItem);
        }
        // set订单所有属性
        order.setOrdertime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        order.setTotal(Float.parseFloat(request.getParameter("total")));
        order.setState(1);// 订单初始状态state为1(即已下单,未付款)
        order.setUid(((User)request.getSession().getAttribute("user")).getUid());
        order.setAddress("");// 暂无地址信息
        // 将订单条目的List集合给予订单对象
        order.setOrderItemList(orderItemList);
        // 将订单存进数据库中
        os.addOrder(order);
        // 将订单条目存进数据库中
        os.addOrderItem(orderItemList);
        // 为session域配置订单对象
        request.getSession().setAttribute("order",order);
        // 购物车提交至订单后,清空购物车
        cart.getCart().clear();
        return "f:/jsps/order/desc.jsp";
    }
    // 得到用户所有订单详情
    public String myOrder(HttpServletRequest request,HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        List<Order> orderList = os.queryByUid(uid);
        request.setAttribute("orderList",orderList);
        return "f:/jsps/order/list.jsp";
    }
    // 用户点击付款后跳转订单详情页面
    public String load(HttpServletRequest request, HttpServletResponse response){
        String oid = request.getParameter("oid");
        Order order = os.load(oid);
        request.getSession().setAttribute("order",order);
        return "f:/jsps/order/desc.jsp";
    }
    // 用户点击确认收货时更改的状态与否
    public String confirm(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        String message = null;
        try {
            os.confirm(oid);
        } catch (OrderException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
            }
        }
        return "f:/jsps/order/msg.jsp";
    }
}
