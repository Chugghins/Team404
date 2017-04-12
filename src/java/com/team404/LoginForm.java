/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

/**
 *
 * @author Andrew
 */
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm
{

    

    private String username;

    private String password;

    public String getUsername()
    {

        return username;

    }

    public void setUsername(String username)
    {

        this.username = username;

    }

    public String getPassword()
    {

        return password;

    }

    public void setPassword(String password)
    {

        this.password = password;

    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {

        this.password = null;

    }
    
    
}
