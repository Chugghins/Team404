/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team404;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chugg1
 */
public class SearchDAO {

    public ArrayList<Movie> search() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getConnection();
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("Select f.film_id, title, release_year, language_id, rental_duration, "
                    + "rental_rate, replacement_cost, rating, first_name, last_name, name From Film as f JOIN film_category As fc "
                    + "ON f.film_id = fc.film_id JOIN category As c ON fc.category_id = c.category_id "
                    + "JOIN film_actor As fa ON f.film_id = fa.film_id JOIN actor As a "
                    + "ON a.actor_id = fa.actor_id;");

            while (resultSet.next()) {
                int film_id = resultSet.getInt("film_id");
                String title = resultSet.getString("title");
                int release_year = resultSet.getInt("release_year");
                int language_id = resultSet.getInt("language_id");
                int rental_duration = resultSet.getInt("rental_duration");
                double rental_rate = resultSet.getDouble("rental_rate");
                double replacement_cost = resultSet.getDouble("replacement_cost");
                String rating = resultSet.getString("rating");
                String actor = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                String genre = resultSet.getString("name");

                Movie m = new Movie(film_id, title, release_year, language_id, rental_duration, rental_rate, replacement_cost, rating, actor, genre);
                movies.add(m);

            }
            resultSet.close();
        } catch (SQLException ex) {
        }

        con.close();
        return movies;

    }
    //        if (genre.equals("") && actor.equals("")) {
//            try {
//                Statement st = con.createStatement();
//                ResultSet resultSet = st.executeQuery("Select f.film_id, release_year, language_id, rental_duration, "
//                        + "rental_rate, replacement_cost, rating, first_name, last_name, name From Film as f JOIN film_category As fc "
//                        + "ON f.film_id = fc.film_id JOIN category As c ON fc.category_id = c.category_id "
//                        + "JOIN film_actor As fa ON f.film_id = fa.film_id JOIN actor As a "
//                        + "ON a.actor_id = fa.actor_id WHERE title LIKE '%" + title + "%';");
//
//                while (resultSet.next()) {
//                    int film_id = resultSet.getInt("film_id");
//                    title = resultSet.getString("title");
//                    int release_year = resultSet.getInt("release_year");
//                    int language_id = resultSet.getInt("language_id");
//                    int rental_duration = resultSet.getInt("rental_duration");
//                    double rental_rate = resultSet.getDouble("rental_rate");
//                    double replacement_cost = resultSet.getDouble("replacement_cost");
//                    String rating = resultSet.getString("rating");
//                    actor = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
//                    genre = resultSet.getString("name");
//
//                    Movie m = new Movie(film_id, title, release_year, language_id, rental_duration, rental_rate, replacement_cost, rating, actor, genre);
//                    movies.add(m);
//                }
//            } catch (SQLException ex) {
//            }
//        } else if (title.equals("") && actor.equals("")) {
//            try {
//                Statement st = con.createStatement();
//                ResultSet resultSet = st.executeQuery("Select f.film_id, title, release_year, language_id, rental_duration, "
//                        + "rental_rate, replacement_cost, rating, first_name, last_name From Film as f JOIN film_category As fc "
//                        + "ON f.film_id = fc.film_id JOIN category As c ON fc.category_id = c.category_id "
//                        + "JOIN film_actor As fa ON f.film_id = fa.film_id JOIN actor As a "
//                        + "ON a.actor_id = fa.actor_id WHERE genre LIKE '%" + genre + "%';");
//
//                while (resultSet.next()) {
//                    int film_id = resultSet.getInt("film_id");
//                    title = resultSet.getString("title");
//                    int release_year = resultSet.getInt("release_year");
//                    int language_id = resultSet.getInt("language_id");
//                    int rental_duration = resultSet.getInt("rental_duration");
//                    double rental_rate = resultSet.getDouble("rental_rate");
//                    double replacement_cost = resultSet.getDouble("replacement_cost");
//                    String rating = resultSet.getString("rating");
//                    actor = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
//                    genre = resultSet.getString("name");
//
//                    Movie m = new Movie(film_id, title, release_year, language_id, rental_duration, rental_rate, replacement_cost, rating, actor, genre);
//                    movies.add(m);
//                }
//            } catch (SQLException ex) {
//            }
//        } else if (genre.equals("") && title.equals("")) {
//            if (actor.contains(" ")) {
//                String[] first_last = actor.split(" ");
//                try {
//                    Statement st = con.createStatement();
//                    ResultSet resultSet = st.executeQuery("Select f.film_id, release_year, language_id, rental_duration, "
//                            + "rental_rate, replacement_cost, rating, name From Film as f JOIN film_category As fc "
//                            + "ON f.film_id = fc.film_id JOIN category As c ON fc.category_id = c.category_id "
//                            + "JOIN film_actor As fa ON f.film_id = fa.film_id JOIN actor As a "
//                            + "ON a.actor_id = fa.actor_id WHERE first_name LIKE '%" + first_last[0]
//                            + "%' AND last_name LIKE '%" + first_last[1] + "%';");
//
//                    while (resultSet.next()) {
//                        int film_id = resultSet.getInt("film_id");
//                        int release_year = resultSet.getInt("release_year");
//                        int language_id = resultSet.getInt("language_id");
//                        int rental_duration = resultSet.getInt("rental_duration");
//                        double rental_rate = resultSet.getDouble("rental_rate");
//                        double replacement_cost = resultSet.getDouble("replacement_cost");
//                        String rating = resultSet.getString("rating");
//                        actor = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
//                        genre = resultSet.getString("name");
//
//                        Movie m = new Movie(film_id, title, release_year, language_id, rental_duration, rental_rate, replacement_cost, rating, actor, genre);
//                        movies.add(m);
//                    }
//
//                } catch (SQLException ex) {
//                }
//            } else {
//
//                try {
//                    Statement st = con.createStatement();
//                    ResultSet resultSet = st.executeQuery("Select f.film_id, release_year, language_id, rental_duration, "
//                            + "rental_rate, replacement_cost, rating, name From Film as f JOIN film_category As fc "
//                            + "ON f.film_id = fc.film_id JOIN category As c ON fc.category_id = c.category_id "
//                            + "JOIN film_actor As fa ON f.film_id = fa.film_id JOIN actor As a "
//                            + "ON a.actor_id = fa.actor_id WHERE first_name LIKE '%" + actor
//                            + "%' OR last_name LIKE '%" + actor + "%';");
//
//                    while (resultSet.next()) {
//                        int film_id = resultSet.getInt("film_id");
//                        int release_year = resultSet.getInt("release_year");
//                        int language_id = resultSet.getInt("language_id");
//                        int rental_duration = resultSet.getInt("rental_duration");
//                        double rental_rate = resultSet.getDouble("rental_rate");
//                        double replacement_cost = resultSet.getDouble("replacement_cost");
//                        String rating = resultSet.getString("rating");
//                        actor = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
//                        genre = resultSet.getString("name");
//
//                        Movie m = new Movie(film_id, title, release_year, language_id, rental_duration, rental_rate, replacement_cost, rating, actor, genre);
//                        movies.add(m);
//                    }
//
//                } catch (SQLException ex) {
//                }
//            }
//        } else if (genre.equals("")) {
//
//        } else if (actor.equals("")) {
//
//        } else if (actor.equals("")) {
//
//        }
//        else
//        {
//            
//        }
}
