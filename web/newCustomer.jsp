<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>New Customer</title>

        
        <style>

            body {background-image: url(https://ih0.redbubble.net/image.279406380.5366/flat,800x800,075,f.u3.jpg); 
                  background-repeat: no-repeat;
                  background-position: top right;
                  background-attachment: fixed;
                  background-size: 30%;
                  background-color: white;

            }

            header{
                padding: 21px;
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

            h1{
                font-size: 250%;
                font-family: fantasy;
            }

            a{
                text-decoration: none;
                color: black;
            }

        </style>
    </head>

    <body>

    <header><a  style="text-decoration: none;" href=login.jsp>Welcome, New Customer!</a></header>

    <center>
        <div>
            <h2>Enter your info below:</h2>

                <table>
                    <tbody>
                        <html:form action="/newCustomer" focus="first_name">
                            <tr>
                                <td>First Name:</td> 
                                <td><html:text property="first_name"/></td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td><html:text property="last_name"/></td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><html:text property="email"/></td>
                            </tr>
                            <tr>
                                <td>Address :</td>
                                <td><html:text property="address"/>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td><html:text property="city"/></td>
                            </tr>
                            <tr>
                                <td>Country:</td>
                                <td><html:text property="country"/></td>    
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td><html:text property="phone"/></td>
                            </tr>       

                            <tr>
                                <td>Password:</td>
                                <td><html:text property="password"/></td>
                            </tr>

                        <br></br>
                        </tr>
                        </tbody>
                    </table></br>
                    <html:submit style="width: 100px; position: fixed;" value="Register"/></br>
                    <p></p>
                </html:form>

        </div>
    </center>
    <div class="footer"><a href=login.jsp>Team404</a></div>
</body>
</html>
