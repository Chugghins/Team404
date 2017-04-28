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
public class ViewCartAction extends org.apache.struts.action.Action {

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
        CartDAO DAO = new CartDAO();
        ArrayList<Movie> cart = new ArrayList<>();
        cart = DAO.getCart(cust_id);
        ArrayList<Movie> wishlist = new ArrayList<>();
        wishlist = DAO.getWishlist(cust_id);
        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("wishlist", wishlist);
        return mapping.findForward(SUCCESS);
    }
}
