package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewOrderFormServlet extends HttpServlet {
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private static final List<String> CARD_TYPE_LIST;
    private Order order;
    private Cart cart;
    private Account account;

    static {
        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        CARD_TYPE_LIST = Collections.unmodifiableList(cardList);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        cart = (Cart) session.getAttribute("cart");

        order = new Order();

        if (account == null || account.getUsername() == null) {
            String message = "You must sign on before attempting to check out.  Please sign on and try checking out again.";
            request.setAttribute("message",message);
            request.getRequestDispatcher(SIGNON).forward(request,response);
        } else if (cart != null) {
            order.initOrder(account, cart);
            session.setAttribute("cardList",CARD_TYPE_LIST);
            session.setAttribute("order",order);
            request.getRequestDispatcher(NEW_ORDER).forward(request,response);
        } else {
            String message = "An order could not be created because a cart could not be found.";
            request.setAttribute("message",message);
            request.getRequestDispatcher(ERROR).forward(request,response);
        }
    }
}
