package com.java8.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

    public static void main(String[] args) {
        Rating ratingg = new Rating();
        User john = new User("John", 30, ratingg);
        john.getRating().add(new Review(5, ""));
        john.getRating().add(new Review(3, "not bad"));
        User julie = new User("Julie", 35, ratingg);
        john.getRating().add(new Review(4, "great!"));
        john.getRating().add(new Review(2, "terrible experience"));
        john.getRating().add(new Review(4, ""));
        List<User> users = Arrays.asList(john, julie);

        users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
        users.stream().reduce(new Rating(),(rating, user) -> Rating.average(rating, user.getRating()),Rating::average);
    }
}
class User{
    private String name;
    private int age;

    private Rating rating;

    public User(String name, int age, Rating rating) {
        this.name = name;
        this.age = age;

        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Review {

    private int points;
    private String review;

    public Review(int points, String review) {
        this.points = points;
        this.review = review;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

 class Rating {

    double points;
    List<Review> reviews = new ArrayList<>();

    public void add(Review review) {
        reviews.add(review);
        computeRating();
    }

    private double computeRating() {
        double totalPoints = reviews.stream().map(Review::getPoints).reduce(0, Integer::sum);
        this.points = totalPoints / reviews.size();
        return this.points;
    }

    public static Rating average(Rating r1, Rating r2) {
        Rating combined = new Rating();
        combined.reviews = new ArrayList<>(r1.reviews);
        combined.reviews.addAll(r2.reviews);
        combined.computeRating();
        return combined;
    }

}
