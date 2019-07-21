/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "NewServlet1", urlPatterns = {"/NewServlet1"})
public class NewServlet1 extends HttpServlet {
    Connection con;
    Statement stmt;
    ResultSet rest;
    
    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/aseef","aseef","aseef");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Cookie[] cookies =request.getCookies();
            String lang=cookies[0].getValue();
            //out.println("<h4>"+cookies[0].getValue()+"</h4></br>");
            //out.println("<h4>"+con.toString()+"</h4></br>");
            stmt = con.createStatement();
            rest = stmt.executeQuery("Select bookname,cost,bookid from books where Language='"+lang+"'");
            //out.println("<img src=\"cbook1.jpg\" alt=\"Italian Trulli\" style=\"width:200px;height:250px;\"");
            out.println("<form action=\"NewServlet2\">");
                
            int i=0;
            out.println("<table style=\"border:1px dash black;\">"
                    + "<tr><th></th><th>Name of the book</th><th>Cost</th></tr>");
            while(rest.next()){
                //out.println("<p>"+rest.getString(1)+" Cost "+rest.getString(2)+"</p></br>");
                out.println("<tr>");
                out.println("<td><img src=\""+rest.getString(1)+".jpg\" style=\"width:100px;height:150px;\"</td>"
                        + "<td><input type=\"checkbox\" name=\"s"+i+"\" value=\""+rest.getString(2)+"\">"+rest.getString(1)+"</td><td> "+rest.getString(2)+"/- Rupees<br></td>");
                i++;
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<input type=\"submit\" name=\"submit\" value=\"Add to Cart\"/>");
            out.println("</form>");
            
            
        } catch (Exception ex) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h4>2"+ex.getMessage()+"</h4>");
        }
            
        }
        
    }


