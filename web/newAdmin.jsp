<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>New Admin Page!</title>

        <style>
            header{
                padding: 21px;
                background-color: lightgray;
                font-family: fantasy;
                font-size: 35px;
                text-align: center;
                right: 0;
                bottom: 0;
                left: 0;
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
                width: 100%;
                height: 100%;

            }
            .one{
                text-decoration: none;
            }
        </style>

    </head>

    <body>

    <header>Add a New Admin!</header>

    <center>
        <div>
            <h2>Enter Admin's info below:</h2>

            <table>
                <tbody>
                    <html:form action="/newAdmin" focus="first_name">
                        <tr>
                            <td colspan="2">
                                <html:errors/>
                            </td>
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
                    </tbody>
                </table></br>

                <html:submit style="width: 100px; position: fixed;" value="Register"/></br>

            </html:form>
            <p align="right" style="padding: 0px 583px 0px 0px">
                <a href="adminPage.jsp"><button style="width: 100px;">Cancel</button></a> 
            </p>


        </div>
    </center>
    <div class="footer"><a class="one" href=login.jsp>Team404</a></div>
</body>

</html>
