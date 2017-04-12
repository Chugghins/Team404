/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Chugg1
 */
public class DbConnectionUtil {
    public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        try
        {
            //Load Properties from db.properties
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream("db.properties");
            prop.load(in);
            in.close();
            //If unsucessful hardcord path and username/path
            if (prop == null)
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/mynewdatabase", "root", "nbuser");
            }
            
            String driver = prop.getProperty("jdbc.driver");
            if (driver != null)
            {
                Class.forName(driver);
            }
            //Get url username and password
            String url = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");

            Connection con = DriverManager.getConnection(url, username, password);
            //Connect error, doesn't exist/wrong creds
            if (con != null)
            {
                return con;
            } else
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/mynewdatabase", "root", "nbuser");
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mynewdatabase", "root", "nbuser");
        }
    }
}
