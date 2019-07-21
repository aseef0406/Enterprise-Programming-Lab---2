<%-- 
    Document   : registration
    Created on : Jan 8, 2019, 3:28:49 PM
    Author     : cse3119
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <body>
        <div style="border:1px dashed black;padding:5pxpx;width:350px;margin:5px">
            <center><h2>Registration Form</h2></center>
        <form action="newjsp.jsp" method="post">
            <table>
                <tr><td>Name: </td><td><input type="text" name="name"></td></tr>
            
                <tr><td>Regd. No. </td><td><input type="text" name="regd"></td></tr>
                
                <tr><td>Username: </td><td><input type="text" name="uname"></td></tr>
            
                <tr><td>Password: </td><td><input type="password" name="pname"></td></tr>
                <tr><td><input type="submit" value="Register"></td></tr>
            </table>
         </form> 
        </div>
    </body>
</html>
