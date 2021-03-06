package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    //    private Object BCrypt;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/users/login.jsp").forward(request, response);
    }

    //commented out below until BCrypt/hashing pw is functioning
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
////        User user = DaoFactory.getUsersDao().findByUsername(username);
////        if (user == null) {
////            response.sendRedirect("/login");
////            return;
////        }
////        boolean validAttempt = BCrypt.checkpw(password, user.getHash());
////        if (validAttempt) {
////            request.getSession().setAttribute("user", user);
////            request.getSession().setAttribute("userID", user.getId());
////            response.sendRedirect("/profile");
////        } else {
////            response.sendRedirect("/login");
////        }
////    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
