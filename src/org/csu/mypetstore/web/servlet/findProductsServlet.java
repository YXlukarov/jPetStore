package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class findProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(findProductsServlet.class);
        response.setContentType("text/xml");
        String name = request.getParameter("keyword");
        PrintWriter out = response.getWriter();
        CatalogService catalogService = new CatalogService();
        List<Product> productList = catalogService.searchProductList(name);
        String res = "";
        for (int i=0;i<productList.size();i++){
                if(i>0){
                    res+=","+productList.get(i).getName();
                }else{
                    res+=productList.get(i).getName();
                }
        }
        out.print("<msg>"+res+"</msg>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
