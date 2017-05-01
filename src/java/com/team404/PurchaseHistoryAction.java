/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

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
public class PurchaseHistoryAction extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession session = request.getSession();
        int cust_id = (Integer) session.getAttribute("cust_id");
        
        TransactionDAO tDAO = new TransactionDAO();
        
        ArrayList<Rental> purchaseHistory = new ArrayList<>();
        purchaseHistory = tDAO.getPurchaseHistory(cust_id);  
        
        request.getSession().setAttribute("rental", purchaseHistory);
        
        return mapping.findForward(SUCCESS);
    }
}
