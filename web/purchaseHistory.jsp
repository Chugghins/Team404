<%-- 
    Document   : purchaseHistory
    Created on : May 1, 2017, 3:42:49 AM
    Author     : Chugg1
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase History</title>
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
        <header>Purchase History</header>

        <table width="100%" border="1" id="cart">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Date</th>
                    <th>Return Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${rental}" var="rental">
                    <tr>
                        <td align="right"><c:out value="${rental.film_id}" /></td>
                        <td><c:out value="${rental.title}" /></td>
                        <td align="right"><c:out value="${rental.rental_date}" /></td>
                        <td align="right"><c:out value="${rental.return_date}" /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p align="right" style="margin-right: 30px">
            <a href="customerPage.jsp"><button style="width: 130px;">Back to Profile</button></a> 
        </p>
    </body>
</html>
