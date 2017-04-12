/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Andrew
 */
public class LoginAction extends Action {

    /**
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String redirect = "";
        LoginForm loginForm = (LoginForm)form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        String[] isStaff = new String[2];
        isStaff = username.split("@");
        if(isStaff[1].equals("salikastaff.com")){
            //Check against staff table
            LoginDAO DAO = new LoginDAO();
            redirect = DAO.adminLogin(username, password);
        }
        else{
            //Check against customer table
            LoginDAO DAO = new LoginDAO();
            redirect = DAO.customerLogin(username, password);
        }
        
            return mapping.findForward(redirect);
       
        
    }
}
