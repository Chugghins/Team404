
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

        <title>Revenue Report Page</title>

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
                position: relative;
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

    <header><a  style="text-decoration: none;" href=adminPage.jsp>Revenue Report!</a></header>
    <p align="right" style="padding: 0px 30px 0px 0px">
        <a href="adminPage.jsp"><button style="width: 130px;">Back to Profile</button></a> 
    </p>
    <div>

        <sql:setDataSource var = "snapshot" driver="com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost:3306/sakila"
                           user="root" password="nbuser"/>
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * FROM sales_by_film_category
        </sql:query>

        <table border="1" id="revenue">
            <thead>
                <tr>
                    <th>Category</th>
                    <th>Total Sales</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <th><c:out value="${row.category}"/></th>
                        <th><c:out value="$${row.total_sales}"/></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script type="text/javascript">

            $(document).ready(function () {
                $('#revenue').DataTable();
            });

        </script>

    </div>

    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>
</body>
</html>
