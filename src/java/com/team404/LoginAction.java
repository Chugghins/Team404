/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Andrew
 */
public class LoginAction extends Action
{

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
            throws Exception
    {
        HttpSession session = request.getSession();
        String redirect = "failure";
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        if (!username.equals("") && username.contains("@"))
        {
            String[] isStaff = new String[2];
            isStaff = username.split("@");
            if (isStaff[1].equals("sakilastaff.com"))
            {
                //Check against staff table
                LoginDAO DAO = new LoginDAO();
                redirect = DAO.adminLogin(username, password);
                String admin_name = DAO.getAdminName(username);
                session.setAttribute("admin_name", admin_name);
            } else
            {
                //Check against customer table
                LoginDAO DAO = new LoginDAO();
                redirect = DAO.customerLogin(username, password);
                Integer cust_id = DAO.getCust_id(username);
                String cust_name = DAO.getCustName(cust_id);
                session.setAttribute("cust_name", cust_name);
                session.setAttribute("cust_id", cust_id);
            }
        }
        return mapping.findForward(redirect);

    }
}
