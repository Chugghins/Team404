/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

/**
 *
 * @author Chugg1
 */
public class Rental {

    private int film_id;
    private String title;
    private String rental_date;
    private String return_date;
    private Double late_fee;
    private int rental_id;

    Rental(int film_id, String title, String rental_date, String return_date) {
        this.film_id = film_id;
        this.title = title;
        this.rental_date = rental_date;
        this.return_date = return_date;
    }

    Rental(int rental_id, int film_id, String title, String rental_date, Double late_fee) {
        this.rental_id = rental_id;
        this.film_id = film_id;
        this.title = title;
        this.rental_date = rental_date;
        this.late_fee = late_fee;
    }

    Rental() {
        super();
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public Double getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(Double late_fee) {
        this.late_fee = late_fee;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

}
