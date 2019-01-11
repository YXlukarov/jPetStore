package org.csu.mypetstore.web.servlet;

import org.apache.log4j.Logger;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignonServlet extends HttpServlet {
    private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private String username;
    private String password;
    private AccountService accountService;
    private Account account;

    private static Logger logger = Logger.getLogger(SignonServlet.class);

    private CatalogService catalogService;
    private List<Product> myList;
    private boolean authenticated;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        username = request.getParameter("username");
        password = request.getParameter("password");
        String clientCheckCode = request.getParameter("validateCode");
        String serverCheckCode = (String)request.getSession().getAttribute("checkcode");
        accountService = new AccountService();
        account = accountService.getAccount(username,password);

        myList = new ArrayList<Product>();
        catalogService = new CatalogService();

        if (clientCheckCode.equals(serverCheckCode)){
            if(account == null){
                account = new Account();
                myList = null;
                authenticated = false;
                logger.error("Signon failed");
                String message = "Invalid username or password.  Signon failed.";
                request.setAttribute("message",message);
                request.getRequestDispatcher(SIGNON).forward(request,response);
            }else{
                account.setPassword(null);
                myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
                authenticated = true;
                session.setAttribute("account",account);
                request.getRequestDispatcher(MAIN).forward(request,response);
            }
        }
        else {
            String value = "验证码检验失败！";
            logger.error("Check code wrong");
            session.setAttribute("message",value);
            request.getRequestDispatcher(SIGNON).forward(request,response);
        }

    }

}
