package org.csu.mypetstore.web.servlet;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SignoffServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private static Logger logger = Logger.getLogger(SignoffServlet.class);
    private List<Product> myList;
    private boolean authenticated;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");

        if(account == null){
            //account = new Account();
            logger.error("User didn`t login when signout");
            String message = "You haven't logined in!";
            request.setAttribute("message",message);
            request.getRequestDispatcher(ERROR).forward(request,response);
        }else{
            logger.info(account.getUsername()+" signed out");
            account = null;
            session.setAttribute("account",account);
            myList = null;
            authenticated = false;
            request.getRequestDispatcher(MAIN).forward(request,response);
        }
    }
}
