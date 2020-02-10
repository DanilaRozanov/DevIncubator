package Servlets;

import Entity.Account;
import Services.AccountService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AccountServlet extends HttpServlet {

    private Account account = new Account();
    private AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.sendRedirect("account.jsp");
    }

}
