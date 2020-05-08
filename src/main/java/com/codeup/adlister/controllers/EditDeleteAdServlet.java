package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

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
        long adId = Long.parseLong(request.getParameter("id"));
        Ad thisAd = DaoFactory.getAdsDao().individualAd(adId);
        request.setAttribute("ad",thisAd);
        request.setAttribute("categories", DaoFactory.getAdsDao().getCategories());
        request.getRequestDispatcher("/WEB-INF/ads/edit-delete-ad.jsp").forward(request, response);
    }

    // If Ads > user_id = users > id, then allow the Edit and Delete functionality

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long thisAdId = Long.parseLong(req.getParameter("id"));
        String thisUserUsername = req.getParameter("username");
        System.out.println(thisUserUsername);
        boolean clickedEditTitle = true;
        boolean clickedEditDescrip = true;
        boolean clickedEditCats = true;
        boolean clickedDelete = true;
        boolean userOwnsAd = (DaoFactory.getAdsDao().individualAd(thisAdId).getUserId()) == (DaoFactory.getUsersDao().findByUsername(thisUserUsername).getId());

        if (userOwnsAd && clickedEditTitle){
            DaoFactory.getAdsDao().editTitle(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (userOwnsAd && clickedEditDescrip){
            DaoFactory.getAdsDao().editDescription(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (userOwnsAd && clickedEditCats){
            DaoFactory.getAdsDao().editCategories(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (userOwnsAd && clickedDelete){
            DaoFactory.getAdsDao().deleteAd(thisAdId);
            resp.sendRedirect("/");
        }
    }
}
