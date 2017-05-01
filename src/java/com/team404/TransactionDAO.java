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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chugg1
 */
public class TransactionDAO {

    public CreditInfo getCreditCard(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        CreditInfo creditInfo = null;
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT creditcard_num, security_code, exp_month, exp_year "
                    + "FROM creditcard WHERE customer_id = " + cust_id);
            resultSet.next();
            String creditcard_num = resultSet.getString("creditcard_num");
            String security_code = resultSet.getString("security_code");
            int exp_month = resultSet.getInt("exp_month");
            int exp_year = resultSet.getInt("exp_year");

            creditInfo = new CreditInfo(cust_id, creditcard_num, security_code, exp_month, exp_year);

        } catch (SQLException ex) {
            System.out.println(ex);
            creditInfo = new CreditInfo(cust_id, "", "", 0, 0);
        }
        con.close();
        return creditInfo;

    }

    public void setCreditCard(CreditInfo c, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        try {

            Statement st1 = con.createStatement();
            ResultSet resultSet = st1.executeQuery("SELECT creditcard_num, security_code, exp_month, exp_year "
                    + "FROM creditcard WHERE customer_id = " + cust_id);
            //Customer does not have previously saved credit Info
            if (!resultSet.isBeforeFirst()) {

                Statement st2 = con.createStatement();
                st2.executeUpdate("INSERT INTO creditcard(customer_id, creditcard_num, security_code, exp_month, exp_year ) "
                        + "VALUES( " + cust_id + ",'"
                        + c.getCreditcard_num() + "','"
                        + c.getSecurity_code() + "',"
                        + c.getExp_month() + ","
                        + c.getExp_year() + ")");
            } //Customer is updating credit info
            else {
                Statement st3 = con.createStatement();
                st3.executeUpdate("UPDATE creditcard SET creditcard_num= '" + c.getCreditcard_num()
                        + "', security_code= '" + c.getSecurity_code() + "', exp_month= " + c.getExp_month()
                        + ", exp_year = " + c.getExp_year() + " WHERE customer_id= " + cust_id + ";");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con.close();

    }

    public boolean validateCredit(CreditInfo c) {
        try {
            if (c.getCreditcard_num().length() > 16 || c.getCreditcard_num().length() < 13) {
                return false;
            }
            if (TryParseLong(c.getCreditcard_num()) == null) {
                return false;
            }
            if (c.getSecurity_code().length() > 4 || c.getSecurity_code().length() > 3) {
                return false;
            }
            if (TryParseLong(c.getSecurity_code()) == null) {
                return false;
            }
            if (c.getExp_month() > 12 || c.getExp_month() < 1) {
                return false;
            }

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);

            if (c.getExp_year() < year) {
                return false;
            }
            if (c.getExp_year() == year && c.getExp_month() < month) {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Invalid Credit Card Information");
            return false;
        }
        return true;
    }

    public void processSale(ArrayList<Movie> cart, double cartTotal, int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        Calendar calendar = Calendar.getInstance();
        int inv_id = 0;
        for (int i = 0; i < cart.size(); i++) {
            try {
                Statement st1 = con.createStatement();
                ResultSet resultSet = st1.executeQuery("SELECT inventory_id "
                        + "FROM inventory WHERE film_id = " + cart.get(i).getFilm_id());
                resultSet.next();
                inv_id = resultSet.getInt("inventory_id");

                Statement st2 = con.createStatement();
                st2.executeUpdate("INSERT INTO rental(rental_date, inventory_id, customer_id, staff_id) "
                        + "VALUES( '" + new java.sql.Date(calendar.getTimeInMillis()) + "'," + inv_id + ", " + cust_id + ",1);");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        try {
            Statement st3 = con.createStatement();
            ResultSet results = st3.executeQuery("SELECT rental_id FROM rental WHERE inventory_id= " + inv_id + " AND customer_id= " + cust_id);
            results.next();
            int rental_id = results.getInt("rental_id");

            Statement st4 = con.createStatement();
            st4.executeUpdate("INSERT INTO payment(customer_id, staff_id, rental_id, amount, payment_date) "
                    + "VALUES( " + cust_id + ", 1, " + rental_id + ", " + cartTotal + ", '" 
                    + new java.sql.Date(calendar.getTimeInMillis()) + "');");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public ArrayList<Rental> getPurchaseHistory(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Rental> rentals = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT f.film_id AS film_id, title, rental_date, return_date "
                    + "FROM rental AS r JOIN inventory AS i ON r.inventory_id = i.inventory_id JOIN "
                    + "film AS f ON f.film_id = i.film_id WHERE customer_id = " + cust_id);

            while (resultSet.next()) {
                int film_id = resultSet.getInt("f.film_id");
                String title = resultSet.getString("title");
                String rental_date = resultSet.getString("rental_date");
                String return_date = resultSet.getString("return_date");

                Rental r = new Rental(film_id, title, rental_date, return_date);
                rentals.add(r);

            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        con.close();
        return rentals;

    }
    public ArrayList<Rental> getCurRented(int cust_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Rental> rentals = new ArrayList<>();
        
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT f.film_id AS film_id, title, rental_date, replacement_cost, rental_rate, length "
                    + "FROM rental AS r JOIN inventory AS i ON r.inventory_id = i.inventory_id JOIN "
                    + "film AS f ON f.film_id = i.film_id WHERE customer_id = " + cust_id + " AND return_date is null");

            while (resultSet.next()) {
                int film_id = resultSet.getInt("f.film_id");
                String title = resultSet.getString("title");
                String rental_date = resultSet.getString("rental_date");
                double late_fee = 0;
                //if(){
                    
                //}

                Rental r = new Rental(film_id, title, rental_date, late_fee);
                rentals.add(r);

            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        con.close();
        
        return rentals;
    }
    public Long TryParseLong(String someText) {
        try {
            return Long.parseLong(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
    
}
