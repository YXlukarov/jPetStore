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
import java.util.Collections;
import java.util.List;

public class EditAccountServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";

    private static Logger logger = Logger.getLogger(EditAccountServlet.class);
    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;

    static {
        List<String> langList = new ArrayList<String>();
        langList.add("english");
        langList.add("japanese");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);

        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");
        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String favouriteCategoryId;
    private String languagePreference;
    private boolean listOption;
    private boolean bannerOption;

    private Account account;
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account)session.getAttribute("account");
        username = account.getUsername();
        password = request.getParameter("password");
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        address1 = request.getParameter("address1");
        address2 = request.getParameter("address2");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");
        country = request.getParameter("country");
        languagePreference = request.getParameter("languagePreference");
        favouriteCategoryId = request.getParameter("favouriteCategoryId");
        if(request.getParameter("listOption") != null){
            listOption = true;
        }else {
            listOption = false;
        }
        if(request.getParameter("bannerOption") != null){
            bannerOption = true;
        }else {
            bannerOption = false;
        }


        if(!username.isEmpty() && !password.isEmpty()){
            account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setFirstName(firstname);
            account.setLastName(lastname);
            account.setEmail(email);
            account.setPhone(phone);
            account.setAddress1(address1);
            account.setAddress2(address2);
            account.setCity(city);
            account.setState(state);
            account.setZip(zip);
            account.setCountry(country);
            account.setLanguagePreference(languagePreference);
            account.setFavouriteCategoryId(favouriteCategoryId);

            logger.info(request.getParameter("username")+" is editing account");
            accountService = new AccountService();
            accountService.updateAccount(account);
            account = accountService.getAccount(account.getUsername());
            account.setListOption(listOption);
            account.setBannerOption(bannerOption);

            logger.info(account.getUsername() + " finished editing");
            session.setAttribute("account",account);
            request.getRequestDispatcher(MAIN).forward(request,response);
        }else{
            request.setAttribute("languages",LANGUAGE_LIST);
            request.setAttribute("categories",CATEGORY_LIST);
            request.getRequestDispatcher(EDIT_ACCOUNT).forward(request,response);
        }
    }

}
