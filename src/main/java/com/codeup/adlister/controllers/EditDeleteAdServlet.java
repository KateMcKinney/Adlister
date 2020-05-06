package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ad/edit-delete")
public class EditDeleteAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");
    }

    // If Ads > user_id = users > id, then allow the Edit and Delete functionality

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long thisAdId = Long.parseLong(req.getParameter("id"));;
        String thisUserUsername = req.getParameter("username");
        boolean clickedEditTitle;
        boolean clickedEditDescrip;
        boolean clickedEditCats;
        boolean clickedDelete;
        boolean userOwnsAd = (DaoFactory.getAdsDao().individualAd(thisAdId).getUserId()) == (DaoFactory.getUsersDao().findByUsername(thisUserUsername).getId());

//        if (userOwnsAd && clickedEditTitle){
//            DaoFactory.getAdsDao().editTitle(thisAdId);
//            resp.sendRedirect("/ad");
//        }
//        if (userOwnsAd && clickedEditDescrip){
//            DaoFactory.getAdsDao().editDescription(thisAdId);
//            resp.sendRedirect("/ad");
//        }
//        if (userOwnsAd && clickedEditCats){
//            DaoFactory.getAdsDao().editCategories(thisAdId);
//            resp.sendRedirect("/ad");
//        }
//        if (userOwnsAd && clickedDelete){
//            DaoFactory.getAdsDao().deleteAd(thisAdId);
//            resp.sendRedirect("/");
//        }
    }
}
