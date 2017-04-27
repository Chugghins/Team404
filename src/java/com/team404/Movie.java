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
public class Movie {

    private int film_id;
    private String title;
    private int length;
    private String description;
    private double rental_rate;
    private String rating;
    private String actor;
    private String genre;

    public Movie(int f_id, String t, String desc, String gnre,
            double r_rate, int lngth, String rting, String a_name) {
        film_id = f_id;
        title = t;
        description = desc;
        genre = gnre;
        rental_rate = r_rate;
        length = lngth;
        rating = rting;
        actor = a_name;

    }

    public Movie() {
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

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor_name) {
        this.actor = actor_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
