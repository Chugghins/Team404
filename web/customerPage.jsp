<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
            .one{
                text-decoration: none;
                color: black;
            }

            button{
                width: 210px
            }
            table, td, th {    
                border: 3.5px solid #5F5B5A;
                border-collapse: collapse;

            }
            th{
                background-color: #ffffff
            }

            th, td {
                padding-right: 10px;
                padding-left: 10px;
            }
            tr:nth-child(odd) {background-color: #C0C0C0}


        </style>
    </head>

    <body>  

    <header>Welcome, ${cust_name}!</header>
    
    <div class="container1">
        <center><h1>Choose an Action:</h1></center>

        <center>
            <html:form action="/search">
                <html:submit style="width: 210px;" value="Search For Movies"/>
            </html:form><p></p>
            <html:form action="/viewCart">
                <html:submit style="width: 210px;" value="Customer Cart"/>
            </html:form><p></p>
            <html:form action="/purchaseHistory">
                <html:submit style="width: 210px;" value="Purchase History"/>
            </html:form><p></p>
            <html:form action="/viewReturn">
                <html:submit style="width: 210px;" value="Return Movies"/>
            </html:form>
        </center>

    </div>

    <div>
        <h1 style="padding: 0px 0px 0px 140px"> Recommendations </h1>
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
                    <th>Add to Cart</th>
                    <th>Add to Wishlist</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.FID}"/></td>
                        <td><c:out value="${row.title}"/></td>
                        <td><c:out value="${row.category}"/></td>
                        <td align="center"><c:url var="url1" value="/addToCart.do">
                                <c:param name="addToCart" value="${row.FID}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url1)}">Add to Cart</a>
                        </td>
                        <td align="center"><c:url var="url2" value="/addToWishlist.do">
                                <c:param name="addToWishlist" value="${row.FID}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url2)}">Add to Wishlist</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <p></p>
    </div>

    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>

</body>
</html>
