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
            h1{
                font-size: 300%;
            }

            h2{
                font-size: 200%;
            }

            p{
                font-size: 150%;
            }
            
            a{
                text-decoration: none;
                color: black;
            }
            
            header{
                
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
            
            body{
                background-color: lightcyan;
            }
        </style>
    </head>
    <body>
        
        
    <header>Failure Page</header>
    
        <div>
            <h1><strong>Uh-Oh!</strong></h1>

            <h2>Either your Username or Password was incorrect...</h2>

            <p><strong>Click <a href=login.jsp>here</a> to try again!</strong></p>

        </div>
        
        <div class="footer"><a href=login.jsp>Team404</a></div>
    </body>
</html>
