
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

        <title>Transaction Report Page</title>

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

    <header><a  style="text-decoration: none;" href=adminPage.jsp>Transaction Report!</a></header>

    <sql:setDataSource var = "snapshot" driver="com.mysql.jdbc.Driver"
                       url = "jdbc:mysql://localhost:3306/sakila"
                       user="root" password="nbuser"/>
    <sql:query dataSource="${snapshot}" var="result">
        SELECT YEAR(payment_date) AS Year, MONTH(payment_date) AS Month, 
        SUM(amount) AS Sales, COUNT(payment_id) AS Transactions FROM payment GROUP BY Year, Month
    </sql:query>
    <table border="1" id="transaction">
        <thead>
            <tr>
                <th>Year</th>
                <th>Month</th>
                <th>Sales ($)</th>
                <th>Transactions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <th><c:out value="${row.Year}"/></th>
                    <th><c:out value="${row.Month}"/></th>
                    <th><c:out value="${row.Sales}"/></th>
                    <th><c:out value="${row.Transactions}"/></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script type="text/javascript">

        $(document).ready(function () {
            $('#transaction').DataTable();
        });

    </script>

</div>

<div class="footer"><a class="one" href=login.jsp>Team404</a></div>
</body>
</html>
