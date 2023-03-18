package com.example.jsteam.model;

import java.util.Vector;

/**
 * @author kareltan
 */
public class DatabaseConfiguration {

    public static final Vector<User> users = new Vector<User>();

    public static final Vector<Game> games = new Vector<Game>();

    public static final Vector<Review> reviews = new Vector<Review>();


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

    public static int findIndexUser(String username){
        int index = -1;

        for (int i = 0 ; i < DatabaseConfiguration.users.size() ; i++){
            if(DatabaseConfiguration.users.get(i).getUsername().equals(username)){
                index = i;
                break;
            }
        }

        return index;
    }


}
