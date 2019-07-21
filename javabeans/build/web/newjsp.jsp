<%-- 
    Document   : newjsp
    Created on : Jan 9, 2019, 5:14:27 PM
    Author     : cse3119
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% String user=request.getParameter("user");%>
        <jsp:useBean id='s' class="com.NewBean">
            <jsp:setProperty name = "s" property = "name" />
            <jsp:setProperty name = "s" property = "regd" />
            <jsp:setProperty name = "s" property = "uname" />
            <jsp:setProperty name = "s" property = "pname" />
        </jsp:useBean>
            
        <p>Details: 
            <jsp:getProperty name = "s" property = "name"/>
            <jsp:getProperty name = "s" property = "regd"/>
            <jsp:getProperty name = "s" property = "uname"/>
            <jsp:getProperty name = "s" property = "pname"/>
        </p>
        <%=s.insert()%>
    </body>
</html>
