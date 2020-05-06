package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ad/edit_delete")
public class EditDeleteAdServlet extends HttpServlet {
    // If Ads > user_id = users > id, then allow the Edit and Delete functionality
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long thisAdId;
        if (edit title){
            thisAdId = Long.parseLong(req.getParameter("id"));
            DaoFactory.getAdsDao().editTitle(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (edit description){
            thisAdId = Long.parseLong(req.getParameter("id"));
            DaoFactory.getAdsDao().editDescription(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (edit categories){
            thisAdId = Long.parseLong(req.getParameter("id"));
            DaoFactory.getAdsDao().editCategories(thisAdId);
            resp.sendRedirect("/ad");
        }
        if (delete ad){
            thisAdId = Long.parseLong(req.getParameter("id"));
            DaoFactory.getAdsDao().deleteAd(thisAdId);
            resp.sendRedirect("/");
        }
    }
}
