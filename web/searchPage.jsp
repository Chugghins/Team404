<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.12.4.js">
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js">
        </script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">


        <title>Search Page</title>

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

        </style>

    </head>

    <body>
    <header>Search Page!</header>
    <p>
        <html:form action="/addToCart" >
            Film ID:
            <input id="addToCart" type="number" name="addToCart" required min="0"/>
            <button type="submit" value="submitToCart" name="submitToCart">Add to Cart</button>
        </html:form>
        &nbsp&nbsp&nbsp&nbsp
        <html:form action="/addToWishlist" >
            Film ID:
            <input id="addToWishlist" type="number" name="addToWishlist" required min="0"/>
            <button type="submit" value="submitToWishlist" name="submitToWishlist">Add to Wishlist</button>
        </html:form>
        &nbsp&nbsp&nbsp&nbsp
        <a href="customerPage.jsp"><button style="width: 130px; float: right; margin-right: 30px">Back to Profile</button></a> 
    </p>
    <p></p>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#movie').DataTable();
        });
    </script>

    <table width="100%" border="1" id="movie">
        <thead>
            <tr>
                <th>Film ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Genre</th>
                <th>Rental Rate</th>
                <th>Film Length</th>
                <th>Rating</th>
                <th>Actors</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movie}" var="movie">
                <tr>
                    <td><c:out value="${movie.film_id}" /></td>
                    <td><c:out value="${movie.title}" /></td>
                    <td><c:out value="${movie.description}" /></td>
                    <td><c:out value="${movie.genre}" /></td>
                    <td><c:out value="$${movie.rental_rate}" /></td>
                    <td><c:out value="${movie.length} Days" /></td>
                    <td><c:out value="${movie.rating}" /></td>
                    <td><c:out value="${movie.actor}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>




</body>
<div class="footer"><a class="one" href=login.jsp>Team404</a></div>

</html>
