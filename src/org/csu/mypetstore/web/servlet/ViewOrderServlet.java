package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewOrderServlet extends HttpServlet {
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";

    private OrderService orderService;
    private Order order;
    private int orderId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_ORDER).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderId = Integer.parseInt(request.getParameter("orderId"));
        HttpSession session = request.getSession();
        orderService = new OrderService();
        order = orderService.getOrder(orderId);

        session.setAttribute("order",order);
        request.getRequestDispatcher(VIEW_ORDER).forward(request,response);
    }
}
