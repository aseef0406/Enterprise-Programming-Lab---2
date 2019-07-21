/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MD-Aseef
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String language=request.getParameter("lang");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie c=new Cookie("lang",language);
        response.addCookie(c);
        response.sendRedirect("\\NewServlet1");
        //out.println("The Selected Language is: "+language);
        //out.print("<br><a href='NewServlet1'>View Details</a>");
        
    }

    
}
