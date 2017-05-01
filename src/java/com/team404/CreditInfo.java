/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Chugg1
 */
public class CreditInfo extends ActionForm{
    private int customer_id;
    private String creditcard_num;
    private String security_code;
    private int exp_month;
    private int exp_year;
    private String saveCredit;
    
    public CreditInfo()
    {
        super();
    }
    public CreditInfo(int customer_id, String creditcard_num, String security_code, int exp_month, int exp_year)
    {
        this.customer_id = customer_id;
        this.creditcard_num = creditcard_num;
        this.security_code = security_code;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
    }

    public String getCreditcard_num() {
        return creditcard_num;
    }

    public void setCreditcard_num(String creditcard_num) {
        this.creditcard_num = creditcard_num;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public int getExp_month() {
        return exp_month;
    }

    public void setExp_month(int exp_month) {
        this.exp_month = exp_month;
    }

    public int getExp_year() {
        return exp_year;
    }

    public void setExp_year(int exp_year) {
        this.exp_year = exp_year;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getSaveCredit() {
        return saveCredit;
    }

    public void setSaveCredit(String saveCredit) {
        this.saveCredit = saveCredit;
    }
    
    
    
}
