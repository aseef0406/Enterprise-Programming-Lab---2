package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cse3119
 */
public class NewBean implements java.io.Serializable 
{ 
private String regd; 
private String name; 
private String uname;
private String pname;
public NewBean() 
    { 
    } 
public void setRegd(String regd) 
    { 
        this.regd = regd; 
    } 
public String getRegd() 
    { 
        return regd; 
    } 
public void setName(String name) 
    { 
        this.name = name; 
    } 
public String getName() 
    { 
        return name; 
    } 
public void setUname(String uname) 
    { 
        this.uname = uname; 
    } 
public String getUname() 
    { 
        return uname; 
    }
public void setPname(String pname) 
    { 
        this.pname = pname; 
    } 
public String getPname() 
    { 
        return pname; 
    }
    public String insert(){
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/aseef","aseef","aseef");
        Statement stmt = con.createStatement();
        //stmt.execute("insert into userbean(name,regd,username,password) values("+name+","+regd+","+uname+","+pname+")");
        stmt.executeUpdate("insert into userbean values('"+name+"','"+regd+"','"+uname+"','"+pname+"')");
        return "sucessfull";
    } catch (Exception ex) {
        Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
           return ex.getMessage();
    }
    }
}