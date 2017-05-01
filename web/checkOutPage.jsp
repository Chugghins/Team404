<%-- 
    Document   : checkOutPage
    Created on : Apr 28, 2017, 2:44:20 AM
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
        <title>Check Out</title>
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
        <header>Check Out</header>
        <table width="100%" border="1" id="cart">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Duration</th>
                    <th>Rental Rate</th>
                    <th>Replacement Cost</th>
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

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p align="left" style="padding: 0px 0px 0px 30px;"><b>Total:<br></br>$${cartTotal}<b></p>

                    <table>
                        <tbody>
                            <html:form action="/processCheckOut">
                                <tr>
                                    <td>Credit Card Number:</td> 
                                    <td><html:text style="text-align: right" property="creditcard_num" value="${creditInfo.creditcard_num}"/></td>
                                </tr>
                                <tr>
                                    <td>Security Code</td>
                                    <td><html:text style="text-align: right" property="security_code" value="${creditInfo.security_code}"/></td>
                                </tr>
                                <tr>
                                    <td>Expiration Month</td>
                                    <td><html:text style="text-align: right" property="exp_month" value="${creditInfo.exp_month}"/></td>
                                </tr>
                                <tr>
                                    <td>Expiration Year</td>
                                    <td><html:text style="text-align: right" property="exp_year" value="${creditInfo.exp_year}"/>
                                </tr>
                            </tbody>
                        </table></br>
                        <t>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</t>
                        <html:checkbox property="saveCredit"/> Save Credit Info <br></br>
                        <t>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</t>
                            <html:submit style="width: 100px; position: fixed;" value="Check Out"/>

                        <p></p>
                    </html:form>
                    <t>&nbsp;&nbsp;&nbsp;&nbsp;</t>
                        <html:form action="/viewCart">
                            <html:submit style="width: 100px;" value="Back to Cart"/>
                        </html:form><p></p>


                    </div>
                    </center>
                    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>
                    </body>
                    </html>
