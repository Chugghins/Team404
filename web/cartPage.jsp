<%-- 
    Document   : cart
    Created on : Apr 27, 2017, 3:30:57 AM
    Author     : Chugg1
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>

        <style>

            header{
                margin-top: 0;

                padding: 1rem;
                background-color: lightgray;
                font-family: fantasy;
                font-size: 35px;
                text-align: center;
                align-items: center;
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

            .one{
                text-decoration: none;
                color: black;
            }
            a.marginLeft {
                margin-left: 1em;
            }
            form {
                display: inline-block; 
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
        <!--two Tables, one for Cart one for Wishlist populate where customer_id equals-->

        <header>Cart</header>
        <table width="100%" border="1" id="cart">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Duration</th>
                    <th>Rental Rate</th>
                    <th>Replacement Cost</th>
                    <th>Move to Wishlist</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cart}" var="movie">
                    <tr>
                        <td align="right"><c:out value="${movie.film_id}" /></td>
                        <td><c:out value="${movie.title}" /></td>
                        <td align="right"><c:out value="${movie.rental_duration} Days" /></td>
                        <td align="right"><c:out value="$${movie.rental_rate}" /></td>
                        <td align="right"><c:out value="$${movie.replacement_cost}" /></td>
                        <td align="center"><c:url var="url1" value="/moveToWishlist.do">
                                <c:param name="id" value="${movie.film_id}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url1)}">Move to Wishlist</a>
                        </td>
                        <td align="center"><c:url var="url2" value="/deleteFromCart.do">
                                <c:param name="id" value="${movie.film_id}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url2)}">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </br>
        <html:form action="/toCheckOut" style="float: right;  margin-right: 30px;"  >
            <button style="width: 130px;" type="submit" value="checkOut" name="checkOut" >Check Out</button>
        </html:form>
        </br></br>
        <header>Wishlist</header>
        <table width="100%" border="1" id="cart" align="center">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Duration</th>
                    <th>Rental Rate</th>
                    <th>Replacement Cost</th>
                    <th>Move to Cart</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${wishlist}" var="movie">
                    <tr>
                        <td align="right"><c:out value="${movie.film_id}" /></td>
                        <td><c:out value="${movie.title}" /></td>
                        <td align="right"><c:out value="${movie.rental_duration} Days" /></td>
                        <td align="right"><c:out value="$${movie.rental_rate}" /></td>
                        <td align="right"><c:out value="$${movie.replacement_cost}" /></td>
                        <td align="center"><c:url var="url1" value="/moveToCart.do">
                                <c:param name="id" value="${movie.film_id}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url1)}">Move to Cart</a>
                        </td>
                        <td align="center"><c:url var="url2" value="/deleteFromWishlist.do">
                                <c:param name="id" value="${movie.film_id}"/>
                            </c:url>
                            <a href="${fn:escapeXml(url2)}">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p align="right" style="margin-right: 30px">
            <a href="customerPage.jsp"><button style="width: 130px;">Back to Profile</button></a> 
        </p>
    </body>
    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>

</html>
