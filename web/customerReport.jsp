
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Customer Report Page</title>

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

        <header>Customer Report!</header>

        <div>

            <h1>Customer Report Stuff</h1>
            <table width="100%" border="1" style="text-align: center">

            <tr>
                <th></th>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Phone Number</th>
                <th>Join Date</th>
                <th colspan="2">Action</th>
            </tr>

            <c:forEach items="${products}" var="product">
                <tr>
                    <td><c:out value=""/></td>
                    <td><c:out value="${product.customer_id}"/></td>
                    <td><c:out value="${product.product_id}"/></td>
                    <td><c:out value="${product.quantity}"/></td>
                    <td><c:out value="${product.shipping_cost}"/></td>
                    <td><c:out value="${product.sales_date}"/></td>
                    <td><c:out value="${product.shipping_date}"/></td>
                    <td><c:url var="url1" value="/goToUpdate.do">
                            <c:param name="id" value="${product.order_num}"/>
                        </c:url>
                        <a href="${fn:escapeXml(url1)}">Update</a>
                    </td>
                    <td><c:url var="url2" value="/delete.do">
                            <c:param name="id" value="${product.order_num}"/>
                        </c:url>
                        <a href="${fn:escapeXml(url2)}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <html:form action="/add">
            <html:submit value="Add"/>
        </html:form>
            

        </div>

        <div class="footer"><a class="one" href=login.jsp>Team404</a></div>
    </body>
</html>
