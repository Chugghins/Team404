
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Admin Page</title>

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

            .container{
                width: 500px;
                border: 3px solid black;
                border-radius: 12px;
                padding: 25px;
                margin: 25px;
                position: relative;
                top: auto;
            }
            .container2{
                width: 500px;
                border: 3px solid black;
                border-radius: 12px;
                padding: 20px;
                margin: 25px;
                position: relative;
                top: auto;
                
            }

            h1{

            }

        </style>
    </head>

    <body>

    <header>Welcome, Admin!</header>


    <div class="container">


        <h1>Need to add a new Admin?</h1>

        <center><h2>Click <a href="newAdmin.jsp"> here!</a></h2></center>
    </div>
    
    
    <div class="container2">
        <center><h1>Reports</h1></center>
        <a href="customerReport.jsp"><button>Customer Report</button></a>
        <a href="inventoryReport.jsp"><button>Inventory Report</button></a>
        <a href="revenueReport.jsp"><button>Revenue Report</button></a>
        <p></p>
        <a href="transactionReport.jsp"><button>Transaction Report</button></a>


    </div>


    <div class="footer"> <a class="one" href=login.jsp>Team404</a></div>

</body>
</html>
