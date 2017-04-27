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
public class CartDAO {

    public void adminLogin(int film_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil db = new DbConnectionUtil();
        Connection con = db.getConnection();

        try {

            if (con != null) {
                System.out.println("Connection Success");
            }
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT title, release_year, language_id, rental_duration, "
                    + "rental_rate, replacement_cost, rating FROM film "
                    + "WHERE film_id = " + film_id + ";");
            String title = resultSet.getString("title");
            int release_year = resultSet.getInt("release_year");
            int language_id = resultSet.getInt("language_id");
            int rental_duration = resultSet.getInt("rental_duration");
            double rental_rate = resultSet.getDouble("rental_rate");
            double replacement_cost = resultSet.getDouble("replacement_cost");
            String rating = resultSet.getString("rating");
                    
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
