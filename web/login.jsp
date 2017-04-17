<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Welcome to the Login Page!</title>

        <style>
            body {background-image: url(http://wallpapercave.com/wp/wp1822739.jpg); 
                  background-repeat: no-repeat;
                  background-position: center;
                  background-attachment: fixed;
                  background-size: cover;

            }

            header{
                padding: 21px;
                font-family: fantasy;
                font-size: 35px;
                color: yellow;
                text-align: center;

            }
            
            .footer{
                padding: 1rem;
                font-family: fantasy;
                font-size: 20px;
                color: yellow;
                text-align: right;
                position: absolute;
                right: 0;
                bottom: 0;
                left: 0;
            }
            
            h1 {color: yellow; 
                font-size: 300%;  
            }
            
            h2{color: yellow;
               font-size: 275%;
               position: relative;
            }
            
            p {color: white;
               font-size: 125%;
            }
            
            a.one{
                text-decoration: none;
            }
            
            .container{
                width: 350px;
                border: 3px solid yellow;
                border-radius: 12px;
                padding: 25px;
                margin: 25px;
                position: relative;
                top: auto;
            }

        </style>
    </head>

    <body>

    <header>Rick and Morty's Intergalactic Video Store!</header>


    <center>
        <div class="container">

            <h2>Login Here!</h2>

            <table>
                <html:form  style="color: white;" action="/Login" focus="username">
                    <tr>
                        <td style="color: yellow; font-size: 18px;">Email:</td> 
                        <td><html:text property="username"/></td>
                    </tr>

                    <tr>
                        <td style="color: yellow; font-size: 18px;">Password:</td> 
                        <td><html:password property="password"/></td><br/>
                    </tr>

                </table></br>
                <html:submit style="width: 100px;" value="Login"/></br>
                <p></p>
                <p style="color: yellow;" > Not a member? Click <a href="newCustomer.jsp">here!</a></p>

            </html:form>
        </div>
    </center>

    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>

</body>

</html>