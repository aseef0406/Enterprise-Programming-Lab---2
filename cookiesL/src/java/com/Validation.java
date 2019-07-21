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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MD-Aseef
 */
@WebServlet(name = "Validation", urlPatterns = {"/Validation"})
public class Validation extends HttpServlet {

    Connection con;
    Statement stmt;
    ResultSet rest;
    public void init(){
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/aseef","aseef","aseef");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
     protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        try {
            
            //Connecting to database
            
            stmt=con.createStatement();
            rest=stmt.executeQuery("select username,password from users");
            
            //getting username and password from textboxes
            String username=req.getParameter("tx1");
            String password=req.getParameter("tx2");
            //setting content type to html
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            out.println("<html><body>");
            //out.println("<h1>Login Details</h1>");
            //        + "username="+username+"</br>"
            //               + "password="+password);
            ServletContext cont=getServletContext();
            int count=0;
            while(rest.next()){
                String uname=rest.getString(1);
                String pwd=rest.getString(2);
                //out.println("<p>"+uname+" "+pwd+"</p>");
                if(username.equals(uname) && password.equals(pwd)){
                    out.println("Login Sucess");
                    RequestDispatcher rd=cont.getRequestDispatcher("/NewServlet4");
                    rd.forward(req, res);
                    count++;
                    break;
                }
            }
            if(count==0){
            out.println("Invalid Credentials</br>Re Enter the Credentials");
            }
            //if(username.equals("asif") && password.equals("123")){
            //    out.println("<p>Login Succesfull</p>");
            //}
            out.println("</body></html>");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
         
     }
     public void destroy(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
