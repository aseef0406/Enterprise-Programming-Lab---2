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
@WebServlet(name = "NewServlet2", urlPatterns = {"/NewServlet2"})
public class NewServlet2 extends HttpServlet {

    
  

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //out.println("<h1>"+request.getContextPath()+"</h1>");
            int sum=0;
            for(int i=0;i<5;i++){
                if(request.getParameter("s"+i)!=null){
                    sum+=Integer.parseInt(request.getParameter("s"+i));
              //out.println(request.getParameter("s"+i)+"</br>");  
            }}
            out.println("<h3>The total cost is "+sum+"</h3>");
            out.println("<form action=\"Payment\">");    
            out.println("<input type=\"submit\" name=\"submit\" value=\"Payment Page\"/>");
            out.println("</form>");
            out.println("</br></body>");
            out.println("</html>");
        }
    }

}
