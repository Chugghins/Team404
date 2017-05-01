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
            ResultSet resultCountry_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                    + c.getCountry() + "';");

            if (!resultCountry_id.isBeforeFirst()) {
                Statement stNewCountry = con.createStatement();
                stNewCountry.executeUpdate("INSERT INTO country(country) VALUES ('"
                        + c.getCountry() + "')");
                stNewCountry.close();
                resultCountry_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                        + c.getCountry() + "';");
                stNewCountry.close();
            }
            resultCountry_id.next();
            int country_id = resultCountry_id.getInt("country_id");
            stCountryID.close();

            Statement stCityID = con.createStatement();
            ResultSet resultCity_id = stCityID.executeQuery("SELECT city_id FROM city WHERE city = '"
                    + c.getCity() + "';");

            if (!resultCity_id.isBeforeFirst()) {
                Statement stNewCity = con.createStatement();
                stNewCity.executeUpdate("INSERT INTO city(city, country_id) VALUES ('"
                        + c.getCity() + "',"
                        + country_id + ")");
                
                resultCity_id = stCityID.executeQuery("SELECT city_id FROM city WHERE city = '"
                        + c.getCity() + "';");
                stNewCity.close();
            }
            resultCity_id.next();
            int city_id = resultCity_id.getInt("city_id");
            stCityID.close();

            Statement stAddressID = con.createStatement();
            ResultSet resultAddress_id = stAddressID.executeQuery("SELECT address_id FROM address WHERE address = '"
                    + c.getAddress() + "';");

            if (!resultAddress_id.isBeforeFirst()) {
                Statement stNewAddress = con.createStatement();
                stNewAddress.executeUpdate("INSERT INTO address(address, city_id, phone) VALUES ('"
                        + c.getAddress() + "',"
                        + city_id + ",'"
                        + c.getPhone() + "')");
                stNewAddress.close();
                resultAddress_id = stAddressID.executeQuery("SELECT address_id FROM address WHERE address = '"
                        + c.getAddress() + "';");

                stNewAddress.close();
            }
            resultAddress_id.next();
            int address_id = resultAddress_id.getInt("address_id");

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

    public boolean isCustEmailAval(Customer c) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement st = con.createStatement();
            ResultSet email = st.executeQuery("SELECT email FROM customer WHERE email = '"
                    + c.getEmail() + "';");

            if (!email.isBeforeFirst()) {
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void newAdmin(Admin a) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {

            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            if (con != null) {
                System.out.println("Connection Success");
            }
            Statement stCountryID = con.createStatement();
            ResultSet resultCountry_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                    + a.getCountry() + "';");

            if (!resultCountry_id.isBeforeFirst()) {
                Statement stNewCountry = con.createStatement();
                stNewCountry.executeUpdate("INSERT INTO country(country) VALUES ('"
                        + a.getCountry() + "')");  
                resultCountry_id = stCountryID.executeQuery("SELECT country_id FROM country WHERE country = '"
                        + a.getCountry() + "';");
                stNewCountry.close();
            }
            resultCountry_id.next();
            int country_id = resultCountry_id.getInt("country_id");
            stCountryID.close();

            Statement stCityID = con.createStatement();
            ResultSet resultCity_id = stCityID.executeQuery("SELECT city_id FROM city WHERE city = '"
                    + a.getCity() + "';");

            if (!resultCity_id.isBeforeFirst()) {
                Statement stNewCity = con.createStatement();
                stNewCity.executeUpdate("INSERT INTO city(city, country_id) VALUES ('"
                        + a.getCity() + "','"
                        + country_id + "')");
                resultCity_id = stCityID.executeQuery("SELECT city_id FROM city WHERE city = '"
                        + a.getCity() + "';");
                stNewCity.close();
            }
            resultCity_id.next();
            int city_id = resultCity_id.getInt("city_id");
            stCityID.close();

            Statement stAddressID = con.createStatement();
            ResultSet resultAddress_id = stAddressID.executeQuery("SELECT address_id FROM address WHERE address = '"
                    + a.getAddress() + "';");

            if (!resultAddress_id.isBeforeFirst()) {
                Statement stNewAddress = con.createStatement();
                stNewAddress.executeUpdate("INSERT INTO address(address, city_id, phone) VALUES ('"
                        + a.getAddress() + "',"
                        + city_id + ",'"
                        + a.getPhone() + "')");
                stNewAddress.close();
                resultAddress_id = stAddressID.executeQuery("SELECT address_id FROM address WHERE address = '"
                        + a.getAddress() + "';");

                stNewAddress.close();
            }
            resultAddress_id.next();
            int address_id = resultAddress_id.getInt(1);

            stAddressID.close();

            Statement stCustomer = con.createStatement();
            stCustomer.executeUpdate("INSERT INTO staff(store_id, first_name, last_name, "
                    + "email, password, address_id) VALUES (1,'"
                    + a.getFirst_name() + "','"
                    + a.getLast_name() + "','"
                    + a.getEmail() + "','"
                    + a.getPassword() + "',"
                    + address_id + ")");

            stCustomer.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isAdminEmailAval(Admin a) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DbConnectionUtil db = new DbConnectionUtil();
            Connection con = db.getConnection();

            Statement st = con.createStatement();
            ResultSet email = st.executeQuery("SELECT email FROM staff WHERE email = '"
                    + a.getEmail() + "';");

            if (!email.isBeforeFirst()) {
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean validateAdminEmail(Admin a) {
        String email = a.getEmail();
        //Counts how many @ characters are in the email
        int count = email.length() - email.replace("@", "").length();

        if (count != 1)//If none or more than one @ symbol
        {
            return false;
        }
        if (!email.endsWith("@sakilastaff.com"))//If staff email does not end with staff domain
        {
            return false;
        }
        return true;
    }
}
