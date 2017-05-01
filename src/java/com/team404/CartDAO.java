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
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Chugg1
 */
public class CartDAO {

    //Adds row to cart based on selected film_id
    public void addToCart(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement querySt = con.createStatement();
            ResultSet resultSet = querySt.executeQuery("SELECT title, rental_rate, rental_duration, replacement_cost FROM film WHERE film_id = " + film_id);
            resultSet.next();
            String title = resultSet.getString("title");
            double rental_rate = resultSet.getDouble("rental_rate");
            int rental_duration = resultSet.getInt("rental_duration");
            double replacement_cost = resultSet.getDouble("replacement_cost");

            querySt.close();

            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO cart(film_id, customer_id, title, "
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

    //Adds row to wishlist based on selected film_id
    public void addToWishlist(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement querySt = con.createStatement();
            ResultSet resultSet = querySt.executeQuery("SELECT title, rental_rate, rental_duration, replacement_cost FROM film WHERE film_id = " + film_id);
            resultSet.next();
            String title = resultSet.getString("title");
            double rental_rate = resultSet.getDouble("rental_rate");
            int rental_duration = resultSet.getInt("rental_duration");
            double replacement_cost = resultSet.getDouble("replacement_cost");

            querySt.close();

            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO wishlist(film_id, customer_id, title, "
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

    //Gets cart information to display on Cart Page
    public ArrayList<Movie> getCart(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Movie> cart = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT film_id, title, rental_duration, rental_rate, "
                    + "replacement_cost FROM cart WHERE customer_id = " + cust_id);

            while (resultSet.next()) {
                int film_id = resultSet.getInt("film_id");
                String title = resultSet.getString("title");
                int rental_duration = resultSet.getInt("rental_duration");
                double rental_rate = resultSet.getDouble("rental_rate");
                double replacement_cost = resultSet.getDouble("replacement_cost");

                Movie m = new Movie(film_id, title, rental_duration, rental_rate, replacement_cost);
                cart.add(m);

            }
            resultSet.close();
        } catch (SQLException ex) {
        }

        con.close();
        return cart;

    }

    //Gets Wishlist information to display on Cart Page
    public ArrayList<Movie> getWishlist(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Movie> wishlist = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT film_id, title, rental_duration, rental_rate, "
                    + "replacement_cost FROM wishlist WHERE customer_id = " + cust_id);

            while (resultSet.next()) {
                int film_id = resultSet.getInt("film_id");
                String title = resultSet.getString("title");
                int rental_duration = resultSet.getInt("rental_duration");
                double rental_rate = resultSet.getDouble("rental_rate");
                double replacement_cost = resultSet.getDouble("replacement_cost");

                Movie m = new Movie(film_id, title, rental_duration, rental_rate, replacement_cost);
                wishlist.add(m);

            }
            resultSet.close();
        } catch (SQLException ex) {
        }

        con.close();
        return wishlist;

    }

    //Checks to see if there are 5 movies in cart already
    public boolean checkNumCart(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        int movInCart = 0;
        int movCurRented = 0;
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT COUNT(*) AS MovInCart FROM cart WHERE customer_id = " + cust_id);
            resultSet.next();
            movInCart = resultSet.getInt("MovInCart");
            resultSet.close();

            Statement st2 = con.createStatement();
            ResultSet resultSet2 = st2.executeQuery("SELECT COUNT(*) AS MovCurRented FROM rental WHERE customer_id = " 
                    + cust_id + " AND return_date is null");
            resultSet2.next();
            movCurRented = resultSet2.getInt("MovCurRented");

            resultSet2.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con.close();

        if (movInCart + movCurRented < 5) {
            return true;
        }
        return false;

    }

    public void removeCart(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM cart WHERE customer_id = " + cust_id + " AND film_id = " + film_id + " Limit 1");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        con.close();
    }

    public void removeWishlist(int film_id, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM wishlist WHERE customer_id = " + cust_id + " AND film_id = " + film_id + " Limit 1");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        con.close();
    }

    
    public void clearCart(int cust_id)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM cart WHERE customer_id = " + cust_id);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        con.close();
    }


}
