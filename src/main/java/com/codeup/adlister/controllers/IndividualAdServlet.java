package com.codeup.adlister.controllers;
import javax.servlet.annotation.WebServlet;
import com.codeup.adlister.dao.DaoFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ad")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //the id is being passed in as a url parameter called "id"
        int thisAdId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("ad", DaoFactory.getAdsDao().individualAd(thisAdId));
    }
}