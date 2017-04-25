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

/**
 *
 * @author Chugg1
 */
public class SearchDAO {
        public ArrayList<Movie> search(String title) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Movie> movies = new ArrayList<>();
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("Select * From film Where title = " + title + ";");

            while (resultSet.next())
            {
                String orderNumber = resultSet.getString("order_num");
                String customerID = resultSet.getString("customer_id");
                String productID = resultSet.getString("product_id");
                String quantity = resultSet.getString("quantity");
                String shippingCost = resultSet.getString("shipping_cost");
                String salesDate = resultSet.getString("sales_date");
                String shippingDate = resultSet.getString("shipping_date");

                Movie m = new Movie();
            }
        } catch (SQLException ex)
        {
        }
        con.close();
        return ;

    }
}
