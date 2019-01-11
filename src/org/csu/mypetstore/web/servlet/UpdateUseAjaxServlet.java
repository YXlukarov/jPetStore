package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

public class UpdateUseAjaxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<CartItem> List=cart.getCartItemList();

        String itemId = request.getParameter("itemid");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        cart.setQuantityByItemId(itemId,quantity);
        session.setAttribute("cart",cart);
        String total1=" ";
        String subtotal1=" ";
        for(CartItem cartItem:List)
        {
            if(itemId.equals(cartItem.getItem().getItemId()))
            {
                BigDecimal total=cartItem.getItem().getListPrice().multiply(new BigDecimal(quantity));
                BigDecimal subtotal=cart.getSubTotal();
                total1 = total.toString();
                subtotal1 = subtotal.toString();
            }
        }

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        out.println("<totals>");
        out.println("<tid>"+total1+"</tid>");
        out.println("<name>"+subtotal1+"</name>");
        out.println("<item>"+itemId+"</item>");
        out.println("</totals>");
        out.flush();
        out.close();
    }
}
