/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

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

    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    
    //error handling. If the text box is empty, throw an error
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        //great tool thats built into struts
        ActionErrors errors = new ActionErrors();
        if (first_name == null || first_name.trim().equals(""))
        {
            errors.add("first_name", new ActionMessage("errors.integer", "First Name"));
        } else if (first_name.length() <= 1)
        {
            errors.add("first_name", new ActionMessage("errors.invalid", "Order number"));
        }
        
        if (last_name == null || last_name.trim().equals(""))
        {
            errors.add("last_name", new ActionMessage("errors.required", "Last Name"));
        } else if (last_name.length() <= 1)
        {
            errors.add("last_name", new ActionMessage("errors.invalid", "Last Name"));
        }
        
        if (email == null || email.trim().equals(""))
        {
            errors.add("email", new ActionMessage("errors.required", "Email"));
        } else if (email.length() - email.replace("@", "").length() != 1)
        {
            errors.add("email", new ActionMessage("errors.email", "Email"));
        }
        else if(!email.endsWith("@sakilastaff.com")){
            errors.add("email", new ActionMessage("errors.email2", "Email"));
        }
        
        if (address == null || address.trim().equals(""))
        {
            errors.add("address", new ActionMessage("errors.required", "Address"));
        } else if (address.length() <= 4)
        {
            errors.add("address", new ActionMessage("errors.invalid", "Address"));
        }
        
        if (city == null || city.trim().equals(""))
        {
            errors.add("city", new ActionMessage("errors.required", "City"));
        } else if (city.length() <= 2)
        {
            errors.add("city", new ActionMessage("errors.invalid", "City"));
        }
        
        if (country == null || country.trim().equals(""))
        {
            errors.add("country", new ActionMessage("errors.required", "Country"));
        } else if (country.length() <= 2)
        {
            errors.add("country", new ActionMessage("errors.invalid", "Country"));
        }
        
        if (phone == null || phone.trim().equals(""))
        {
            errors.add("phone", new ActionMessage("errors.required", "Phone"));
        }
        else if (phone.length() < 10)
        {
            errors.add("phone", new ActionMessage("errors.minlength", "Phone", "10"));
        }
        
        if (password == null || password.trim().equals(""))
        {
            errors.add("password", new ActionMessage("errors.required", "Password"));
        }
        else if (password.length() < 8)
        {
            errors.add("password", new ActionMessage("errors.minlength", "Password", "8"));
        }
        
        return errors;
    }

}
