package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

public class UpdateCartQuantitiesServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(UpdateCartQuantitiesServlet.class);
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private Cart cart;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart)session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }

        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            int quantity = Integer.parseInt(request.getParameter(itemId));
            cart.setQuantityByItemId(itemId, quantity);
            if (quantity < 1) {
                cartItems.remove();
            }
        }

        request.getRequestDispatcher(VIEW_CART).forward(request,response);
    }
}
