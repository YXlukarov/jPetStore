package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewItemServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ViewItemServlet.class);
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private String itemId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        CatalogService catalogService = new CatalogService();
        Item item = catalogService.getItem(itemId);
        Product product = item.getProduct();

        logger.info("Viewed "+itemId);
        HttpSession session = request.getSession();
        session.setAttribute("item",item);
        session.setAttribute("product",product);

        request.getRequestDispatcher(VIEW_ITEM).forward(request,response);
    }
}
