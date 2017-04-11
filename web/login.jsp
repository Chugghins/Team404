<%-- 
    Document   : Login
    Created on : Apr 10, 2017, 10:17:05 PM
    Author     : Andrew
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Welcome to the Login Page!</title>
    </head>
    <body>
        <center><h1>Welcome to our website!</h1></center>

        <div class="w3-container">
            <h1>Login Here!</h1>
            
            <html:form action="/Login" focus="username">
                Username: <html:text property="username"/><br/>
                <p></p>
                Password: <html:password property="password"/><br/>
                <p></p>
                <html:submit value="Login"/>
                <p></p>
                <p>Not already a member? Click <a href="http://www.yahoo.com">here!</a></p>
            </html:form>
        </div>
    </body>

</html>
