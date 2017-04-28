<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Customer Page</title>
        <style>

            header{
                padding: 1rem;
                background-color: lightgray;
                font-family: fantasy;
                font-size: 35px;
                text-align: center;
                position: relative;
            }

            .footer{
                padding: 1rem;
                background-color: lightgray;
                font-family: fantasy;
                font-size: 20px;
                text-align: right;
                position: absolute;
                right: 0;
                bottom: 0;
                left: 0;
            }

            .container1{
                width: 500px;
                border: 3px solid black;
                border-radius: 12px;
                padding: 20px;
                margin: 25px;
                position: relative;
                top: auto;
            }
            a{
                text-decoration: none;
                color: black;
            }
            
            button{
                width: 210px
            }

        </style>
    </head>

    <body>  

    <header>Welcome, Customer!</header>
    <div class="container1">
        <center><h1>Customer Things!</h1></center>

        <center>
            <html:form action="/search">
                <html:submit style="width: 210px;" value="Search For Movies"/>
            </html:form><p></p>
            <html:form action="/viewCart">
                <html:submit style="width: 210px;" value="Customer Cart"/>
            </html:form><p></p>
            <a href="inventoryReport.jsp"><button style="width: 210px;">Purchase History</button></a>
        </center>
        
    </div>
    
    <div>
    <sql:setDataSource var = "snapshot" driver="com.mysql.jdbc.Driver"
                       url = "jdbc:mysql://localhost:3306/sakila"
                       user="root" password="nbuser"/>
    <sql:query dataSource="${snapshot}" var="result">
        SELECT title, category, FID
        FROM film_list
        ORDER BY RAND(title) DESC
        LIMIT 5;
    </sql:query>
        
        <table border="1" id="customer">
        <thead>
        <tr>
            <th>Film ID</th>
            <th>Movie Title</th>
            <th>Movie Genre</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <th><c:out value="${row.FID}"/></th>
                <th><c:out value="${row.title}"/></th>
                <th><c:out value="${row.category}"/></th>    
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    
    <div class="footer"><a href=login.jsp>Team404</a></div>

</body>
</html>
