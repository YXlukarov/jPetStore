package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShippingFormServlet extends HttpServlet {
    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";

    private Order order;
    private OrderService orderService;
    private Cart cart;
    private String shipToFirstName;
    private String shipToLastName;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipZip;
    private String shipCountry;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        order = (Order)session.getAttribute("order");

        shipToFirstName = request.getParameter("shipToFirstName");
        shipToLastName = request.getParameter("shipToLastName");
        shipAddress1 = request.getParameter("shipAddress1");
        shipAddress2 = request.getParameter("shipAddress2");
        shipCity = request.getParameter("shipCity");
        shipState = request.getParameter("shipState");
        shipZip = request.getParameter("shipZip");
        shipCountry = request.getParameter("shipCountry");

        order.setShipToFirstName(shipToFirstName);
        order.setShipToLastName(shipToLastName);
        order.setShipAddress1(shipAddress1);
        order.setShipAddress2(shipAddress2);
        order.setShipCity(shipCity);
        order.setShipState(shipState);
        order.setShipZip(shipZip);
        order.setShipCountry(shipCountry);

        //成功存储订单后，清空购物车
        orderService = new OrderService();
        orderService.insertOrder(order);
        cart = (Cart)session.getAttribute("cart");
        cart = new Cart();
        session.setAttribute("cart",cart);
        session.setAttribute("order",order);
        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
    }
}
