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
    private int release_year;
    private int language_id;
    private int rental_duration;
    private double rental_rate;
    private double replacement_cost;
    private String rating;
    private String actor;
    private String genre;
    
    public Movie(int f_id, String t, int r_year, int l_id, int r_duration, 
            double r_rate, double r_cost, String rting, String a_name, String gnre)
    {
        film_id = f_id;
        title = t;
        release_year = r_year;
        language_id = l_id;
        rental_duration = r_duration;
        rental_rate = r_rate;
        replacement_cost = r_cost;
        rating = rting;
        actor = a_name;
        genre = gnre;
    }
    public Movie(){
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

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
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

    
    
}
