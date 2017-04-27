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

    public void addToCart(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement querySt = con.createStatement();
            ResultSet resultSet = querySt.executeQuery("SELECT title, rental_rate, rental_duration, replacement_cost FROM film WHERE film_id = " + film_id);

            String title = resultSet.getString("title");
            double rental_rate = resultSet.getDouble("rental_rate");
            int rental_duration = resultSet.getInt("rental_duration");
            double replacement_cost = resultSet.getDouble("replacement_cost");

            querySt.close();

            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO cart(film_id, customer_id, title "
                    + "rental_duration, rental_rate, replacement_cost) "
                    + "VALUES (" + film_id + ","
                    + cust_id + ",'"
                    + title + "',"
                    + rental_duration + ","
                    + rental_rate + ","
                    + replacement_cost + ")");

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void addToWishlist(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement querySt = con.createStatement();
            ResultSet resultSet = querySt.executeQuery("SELECT * FROM film WHERE film_id = " + film_id);

            String title = resultSet.getString("title");
            double rental_rate = resultSet.getDouble("rental_rate");
            int rental_duration = resultSet.getInt("rental_duration");
            double replacement_cost = resultSet.getDouble("replacement_cost");

            querySt.close();

            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO wishlist(film_id, customer_id, title "
                    + "rental_duration, rental_rate, replacement_cost) "
                    + "VALUES (" + film_id + ","
                    + cust_id + ",'"
                    + title + "',"
                    + rental_duration + ","
                    + rental_rate + ","
                    + replacement_cost + ")");

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    //TODO: Remove from cart/wishlist, Move movie from Cart -> Wishlist, Move movie from Wishlist -> Cart
}
