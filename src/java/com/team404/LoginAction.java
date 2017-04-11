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
        LoginForm loginForm = (LoginForm)form;
        if(loginForm.getUsername() == null || loginForm.getPassword() == null ||
        !loginForm.getUsername().equalsIgnoreCase("andrew") || !loginForm.getPassword().equals("andrew")){
            return mapping.findForward("failure");
        }
        else
        {
            return mapping.findForward("success");
        }
    }
}
