package com.emc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private final int id;
    private final String title;
    private final double price;
    private final String description;
    private final String category;
    private final String image;
    //    private  int rate;
//    private  int count;
    private final Rating rating;
    // private final Map<String, Integer> rating;
    private final int quantity;
    private final LocalDateTime deliverDate;
    private final LocalDateTime expirationDate;

    private static final String DATE_FORMAT = "dd-MMM-yyyy 'at' hh:mm a";

    public Product(int id, String title, double price, String description, String category, String image, Map<String, Integer> rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = createRating(rating);
        this.quantity = randBetween(1, 100);
        this.deliverDate = randomDate();
        this.expirationDate = randomDate();
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("rating")
    private Rating createRating(Map<String, Integer> rating) {
        return new Rating(rating.get("rate"), rating.get("count"));

    }

    private LocalDateTime randomDate() {
        int year = randBetween(1990, 2020);
        int month = randBetween(1, 12);
        int day = randomDay(month);
        int hour = randBetween(0, 23);
        int minute = randBetween(0, 59);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private int randomDay(int month) {
        switch (month) {
            case 2:
                return randBetween(1, 28);
            case 4:
            case 6:
            case 9:
            case 11:
                return randBetween(1, 30);
            default:
                return randBetween(1, 31);
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }


    public Rating getRating() {
        return rating;
    }

    public String getDeliverDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return formatter.format(deliverDate);
    }

    public String getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return formatter.format(expirationDate);
    }

    public LocalDateTime deliverDate() {
        return deliverDate;
    }

    public LocalDateTime expirationDate() {
        return expirationDate;
    }
}
