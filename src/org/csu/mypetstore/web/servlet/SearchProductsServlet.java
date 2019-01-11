package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SearchProductsServlet extends HttpServlet {
    private static final String VIEW_SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String keyword;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyword = request.getParameter("keyword");

        if (keyword == null || keyword.length() < 1) {
            String message = "Please enter a keyword to search for, then press the search button.";
            request.setAttribute("message",message);
            request.getRequestDispatcher(ERROR).forward(request,response);
        } else {
            CatalogService catalogService = new CatalogService();
            List<Product> productList = catalogService.searchProductList(keyword);

            HttpSession session = request.getSession();
            session.setAttribute("productList",productList);

            request.getRequestDispatcher(VIEW_SEARCH_PRODUCTS).forward(request,response);
        }


    }

}
