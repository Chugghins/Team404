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
                padding: 1rem;
                background-color: lightgray;
                font-family: fantasy;
                font-size: 35px;
                text-align: center;

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

        </style>

    </head>

    <body>

    <header>Search Page!</header>
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
                <th>Release Year</th>
                <th>Language ID</th>
                <th>Rental Duration</th>
                <th>Rental Rate</th>
                <th>Replacement Cost</th>
                <th>Rating</th>
                <th>Actor</th>
                <th>Genre</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movie}" var="movie">
                <tr>
                    <td><c:out value="${movie.film_id}" /></td>
                    <td><c:out value="${movie.title}" /></td>
                    <td><c:out value="${movie.release_year}" /></td>
                    <td><c:out value="${movie.language_id}" /></td>
                    <td><c:out value="${movie.rental_duration}" /></td>
                    <td><c:out value="${movie.rental_rate}" /></td>
                    <td><c:out value="${movie.replacement_cost}" /></td>
                    <td><c:out value="${movie.rating}" /></td>
                    <td><c:out value="${movie.actor}" /></td>
                    <td><c:out value="${movie.genre}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>



    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>
</body>
</html>