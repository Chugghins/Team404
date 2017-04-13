/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chugg1
 */
public class LoginDAO {

    public String adminLogin(String email, String password ) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        DbConnectionUtil db = new DbConnectionUtil();
        Connection con = db.getConnection();

        try
            {
                Statement st = con.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM Staff WHERE email = '" + email + "' AND password = '" + password + "';" );
                if(!resultSet.isBeforeFirst())
                {
                    //Row not found
                    return "failure";
                }
                else{
                    return "adminSuccess";
                }
            } 
        catch (SQLException ex)
            {
                System.out.println(ex);
            }
        
            con.close();
            return "failure";
        
    }
    public String customerLogin(String email, String password ) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        DbConnectionUtil db = new DbConnectionUtil();
        Connection con = db.getConnection();

        try
            {
                Statement st = con.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM Customer WHERE email = '" + email 
                        + "' AND password = '" + password + "';");
                if(!resultSet.isBeforeFirst())
                {
                    //Row not found
                    return "failure";
                }
                else{
                    return "customerSuccess";
                }
            } 
        catch (SQLException ex)
            {
                System.out.println(ex);
            }
        
            con.close();
            return "failure";
        
    }
}
