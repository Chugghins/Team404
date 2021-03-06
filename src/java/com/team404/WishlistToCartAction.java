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
public class WishlistToCartAction extends org.apache.struts.action.Action {

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
        int film_id = Integer.parseInt(request.getParameter("id"));
        CartDAO DAO = new CartDAO();
        int cust_id = (Integer) session.getAttribute("cust_id");
        //Checks to make sure customer does not have 5 movies in cart/rented out
        if (DAO.checkNumCart(cust_id)) {
            DAO.removeWishlist(film_id, cust_id);
            DAO.addToCart(film_id, cust_id);

            ArrayList<Movie> cart = new ArrayList<>();
            cart = DAO.getCart(cust_id);
            request.getSession().setAttribute("cart", cart);

            ArrayList<Movie> wishlist = new ArrayList<>();
            wishlist = DAO.getWishlist(cust_id);
            request.getSession().setAttribute("wishlist", wishlist);
            return mapping.findForward(SUCCESS);
        }
        return mapping.findForward(SUCCESS);
    }
}
