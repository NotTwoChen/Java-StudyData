package com.wsh.cart.web;

import com.wsh.book.domain.Book;
import com.wsh.book.service.BookService;
import com.wsh.cart.domain.Cart;
import com.wsh.cart.domain.CartItem;
import com.wsh.user.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookService bs = new BookService();
    // 在书籍详情页面点击放入购物车时,会将表单中的书籍信息和数目封装成一个购物条目
    public String add(HttpServletRequest request, HttpServletResponse response){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        int count = Integer.parseInt(request.getParameter("count"));
        // 判断购物车内是否已经存在同键购物条目
        if (cart.getCart().get(bid) != null){//如果存在,则取出购物车内单独购物条目,对count进行更改
            CartItem item = cart.getCart().get(bid);
            int itemCount = item.getCount();
            item.setCount(itemCount+count);
        }else {//如果不存在,则重新创建一个新的购物条目,并放入购物车
            Book book = bs.queryByBid(bid);
            CartItem cartItem = new CartItem(book,count);
            cart.getCart().put(bid,cartItem);
        }
        return "r:/jsps/cart/list.jsp";
    }
    // 清空购物车即将购物车实体类实例化对象的Map集合清空,直接调用Map的clear方法
    public String clear(HttpServletRequest request,HttpServletResponse response){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getCart().clear();
        return "r:/jsps/cart/list.jsp";
    }
    // 在购物车中删除单独条目即将购物车实体类实例化对象的Map集合中对应键remove
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getCart().remove(bid);
        return "r:/jsps/cart/list.jsp";
    }
}
