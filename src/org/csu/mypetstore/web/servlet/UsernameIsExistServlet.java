package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsernameIsExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(UsernameIsExistServlet.class);
        String username = request.getParameter("username");
        AccountService service = new AccountService();
        logger.info(username+" Servlet");
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();

        if (service.usernameIsExist(username)){
            out.print("<msg>Exist</msg>");
        }else {
            out.print("<msg>Not Exist</msg>");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
