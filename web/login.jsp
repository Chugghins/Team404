<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Welcome to the Login Page!</title>
        <style>
            body {background-image: url(http://wallpapercave.com/wp/wp1822739.jpg); 
                  background-repeat: no-repeat;
                  background-position: center;
                  background-attachment: fixed;
                  background-size: cover;
            }
            h1 {color: yellow; 
                font-size: 300%;
            }
            h2{color: yellow;
               font-size: 275%;
            }
            p {color: white;
               font-size: 125%;
            }

        </style>
    </head>

    <body>

        <center><h1>Rick and Morty's Intergalactic Video Store!</h1></center></br>

        <center>

            <div style="position: static;">

                <h2>Login Here!</h2>

                <div style="font-size: 120%; position: relative; right: 35px;">
                    <table border="0">
                        <html:form  style="color: white" action="/Login" focus="username">

                            <tr>
                                <td style="color: yellow;">Email:</td> 
                                <td><html:text property="username"/></td><br/>
                            </tr>
                            <tr>
                                <td style="color: yellow;">Password:</td> 
                                <td><html:password property="password"/></td><br/>
                            </tr>
                        </table></br>
                        <html:submit style="width: 100px; position: fixed;" value="Login"/></br>
                        <p></p>
                        <p style="position: relative; left: 20px; color: yellow;" > Not a member? Click <a href="newCustomer.jsp">here!</a></p>

                    </html:form>

                </div>

            </div>

        </center>

    </body>

</html>
