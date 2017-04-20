/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import org.apache.struts.action.ActionForm;

public class Admin extends ActionForm {

    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String password;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateEmail() {
        //Counts how many @ characters are in the email
        int count = email.length() - email.replace("@", "").length();

        if (count != 1)//If none or more than one @ symbol
        {
            return false;
        }
        //If staff email ends with staff domain returns true, else returns false
        return email.endsWith("@sakilastaff.com");
    }

}
