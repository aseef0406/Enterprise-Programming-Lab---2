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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cse3119
 */
@WebServlet(name = "Payment", urlPatterns = {"/Payment"})
public class Payment extends HttpServlet {

    

    
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
            out.println("<body><h2>Welcome to our bank</h2>");
            HttpSession s=request.getSession();
            s.setMaxInactiveInterval(30);
            
            //out.println("<h1>"+request.getContextPath()+"</h1>");
                
            out.println("<form action=\"Validation\" method=\"get\">");
            out.println("UserName:<input type=\"text\" name=\"tx1\"/>");
            out.println("Password:<input type=\"text\" name=\"tx2\"/>");
            out.println("<input type=\"submit\" name=\"submit\" value=\"submit\"/>");
            out.println("</form>");
            out.println("</br></body>");
            out.println("</html>");
        }
    
    }

}
