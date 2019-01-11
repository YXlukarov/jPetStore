package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderServlet extends HttpServlet {
    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPING = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private static Logger logger = Logger.getLogger(NewOrderServlet.class);

    private OrderService orderService;
    private Cart cart;

    private Order order = null;
    private String shippingAddressRequired;
    private String cardType;
    private String creditCard;
    private String expiryDate;
    private String billToFirstName;
    private String billToLastName;
    private String billAddress1;
    private String billAddress2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billCountry;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        shippingAddressRequired = request.getParameter("shippingAddressRequired");
        HttpSession session = request.getSession();
        order = (Order)session.getAttribute("order");

        cardType = request.getParameter("cardType");
        creditCard = request.getParameter("creditCard");
        expiryDate = request.getParameter("expiryDate");
        billToFirstName = request.getParameter("billToFirstName");
        billToLastName = request.getParameter("billToLastName");
        billAddress1 = request.getParameter("billAddress1");
        billAddress2 = request.getParameter("billAddress2");
        billCity = request.getParameter("billCity");
        billState = request.getParameter("billState");
        billZip = request.getParameter("billZip");
        billCountry = request.getParameter("billCountry");

        //如果勾选了shippingAddress
        if(shippingAddressRequired != null && shippingAddressRequired.equals("true")){
            order.setCardType(cardType);
            order.setCreditCard(creditCard);
            order.setExpiryDate(expiryDate);
            order.setBillToFirstName(billToFirstName);
            order.setBillToLastName(billToLastName);
            order.setBillAddress1(billAddress1);
            order.setBillAddress2(billAddress2);
            order.setBillCity(billCity);
            order.setBillState(billState);
            order.setBillZip(billZip);
            order.setBillCountry(billCountry);

            session.setAttribute("order",order);
            request.getRequestDispatcher(SHIPPING).forward(request,response);
        }else if(order != null){
            order.setCardType(cardType);
            order.setCreditCard(creditCard);
            order.setExpiryDate(expiryDate);
            order.setBillToFirstName(billToFirstName);
            order.setBillToLastName(billToLastName);
            order.setBillAddress1(billAddress1);
            order.setBillAddress2(billAddress2);
            order.setBillCity(billCity);
            order.setBillState(billState);
            order.setBillZip(billZip);
            order.setBillCountry(billCountry);

            logger.info("Order info: "+creditCard+" "+billAddress1+" "+billAddress2);
            //成功存储订单后，清空购物车
            orderService = new OrderService();
            orderService.insertOrder(order);
            cart = (Cart)session.getAttribute("cart");
            cart = new Cart();
            session.setAttribute("cart",cart);
            session.setAttribute("order",order);
            request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
        }else{
            String message = "An error occurred processing your order (order was null).";
            request.setAttribute("message",message);
            request.getRequestDispatcher(ERROR).forward(request,response);
        }
    }
}
