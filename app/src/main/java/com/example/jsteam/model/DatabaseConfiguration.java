package com.example.jsteam.model;

import java.util.Vector;

/**
 * @author kareltan
 */
public class DatabaseConfiguration {

    private static final Vector<User> users = new Vector<User>();

    private static final Vector<Game> games = new Vector<Game>();

    private static final Vector<Review> reviews = new Vector<Review>();


    public static void DatabaseUser(Integer userId, String username, String password, String email, String region, String phoneNumber){
        User user = new User(userId, username, password, email, region, phoneNumber);
        users.add(user);
    }

    public static void DatabaseGame(String name, String genre, Float rating, Integer price, String description){
        Game game = new Game(name, genre, rating, price, description);
        games.add(game);
    }

    public static void DatabaseReview(String gameName, String content, String username){
        Review review = new Review(gameName, content, username);
        reviews.add(review);
    }


}
