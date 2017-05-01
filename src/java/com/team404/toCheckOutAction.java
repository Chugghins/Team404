/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Chugg1
 */
public class toCheckOutAction extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        int cust_id = (Integer) session.getAttribute("cust_id");
        CartDAO cDAO = new CartDAO();
        ArrayList<Movie> cart = new ArrayList<>();
        cart = cDAO.getCart(cust_id);
        double cartTotal = 0;
        for(int x = 0; x < cart.size(); x++){
            cartTotal += cart.get(x).getRental_rate();
        }
        cartTotal = (int)(cartTotal * Math.pow(10 , 2));
        cartTotal = cartTotal/100;
        CreditInfo creditInfo = (CreditInfo) form;
        TransactionDAO tDAO = new TransactionDAO();
        creditInfo = tDAO.getCreditCard(cust_id);
        
        request.getSession().setAttribute("creditInfo", creditInfo);
        request.getSession().setAttribute("cartTotal", cartTotal);
        request.getSession().setAttribute("cart", cart);
        return mapping.findForward(SUCCESS);
    }
}

