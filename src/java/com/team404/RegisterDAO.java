/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Chugg1
 */
public class RegisterDAO {

    public void newCustomer(Customer c) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date createDate = Calendar.getInstance().getTime();
            String today = dateFormat.format(createDate);

            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            if (con != null) {
                System.out.println("Connection Success");
            }
            Statement stCountryID = con.createStatement();
            ResultSet country_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                    + c.getCountry() + "';");
           
            if (country_id == null) {
                Statement stNewCountry = con.createStatement();
                stNewCountry.executeUpdate("INSERT INTO country(country) VALUES ('"
                        + c.getCountry() + "')");
                stNewCountry.close();
                 country_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                    + c.getCountry() + "';");
                 stNewCountry.close();
            } 
                stCountryID.close();
                
            Statement stCityID = con.createStatement();
            ResultSet city_id = stCityID.executeQuery("SELECT city_id FROM city WHERE city = '"
                    + c.getCity() + "';");
           
            if (city_id == null) {
                Statement stNewCity = con.createStatement();
                stNewCity.executeUpdate("INSERT INTO city(city, country_id) VALUES ('"
                        + c.getCity() + "','"
                        + country_id + "')");
                stNewCity.close();
                 city_id = stCountryID.executeQuery("SELECT city_id FROM city WHERE city = '"
                    + c.getCity() + "';");
                 stNewCity.close();
            } 
                stCityID.close();
                
            

                Statement stNewAddress = con.createStatement();
                stNewAddress.executeUpdate("INSERT INTO address(address, city_id, phone) VALUES ('"
                        + c.getAddress() + "',"
                        + city_id + ",'"
                        + c.getPhone() + "')");
                stNewAddress.close();
                Statement stAddressID = con.createStatement();
                ResultSet address_id = stAddressID.executeQuery("SELECT address_id FROM address WHERE address = '"
                    + c.getCity() + "';");
                 stNewAddress.close();
            
           stAddressID.close();
                
            Statement stCustomer = con.createStatement();
            stCustomer.executeUpdate("INSERT INTO customer(store_id, first_name, last_name, "
                    + "email, password, address_id, create_date) VALUES (1,'"
                    + c.getFirst_name() + "','"
                    + c.getLast_name() + "','"
                    + c.getEmail() + "','"
                    + c.getPassword() + "',"
                    + address_id + ",'"
                    + today + "')");

            stCustomer.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
