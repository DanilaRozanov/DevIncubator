package Servlets;

import Entity.User;
import Services.UserService;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    private User user = new User();
    private UserService userService = new UserService();
    public void init() throws ServletException {
        super.init();
        try {
            user = userService.getRichestUser();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());
            System.out.println("error");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("user.jsp");
    }
}
