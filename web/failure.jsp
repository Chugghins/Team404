<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>ERROR</title>

        <style>

            body {background-image: url(https://ih1.redbubble.net/image.59867335.8235/flat,800x800,075,f.u1.jpg); 
                  background-repeat: no-repeat;
                  background-position: center right;
                  background-attachment: fixed;
                  background-size: 28%;
                  background-color: white;

            }
            
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
                width: 725px;
                border: 4px solid black;
                border-radius: 12px;
                padding: 25px;
                margin: 150px;
                position: relative;
                top: auto;

            }
            
            h1{
                font-weight: bold;
            }

        </style>
    </head>
    <body>


    <header>Failure Page</header>

    <center>
        <div class="container">
            <center><h1>Uh-Oh!</h1></center>

            <h2>Either your Username or Password was incorrect...</h2>

            <a href=login.jsp><button>Try Again!</button></a>

        </div>

        <div class="footer"> <a class="one" href=login.jsp>Team404</a></div>
    </center>
</body>
</html>
