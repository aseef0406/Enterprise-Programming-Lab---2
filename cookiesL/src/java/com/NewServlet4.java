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
@WebServlet(name = "NewServlet4", urlPatterns = {"/NewServlet4"})
public class NewServlet4 extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>payment page"
                    + "</title>"); 
            out.println("</head>");
            
            
            HttpSession s=request.getSession(false);
            if(s!=null){
                out.println("Payment Sucessful");
            }else{
            out.println("Session Expired");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
