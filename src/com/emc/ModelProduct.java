package com.emc;

import java.util.Map;

public class ModelProduct {
    private  int id;
    private String title;
    private double price;
    private  String description;
    private String category;
    private String image;
    //nested object first solution is map
    private Map<String, Integer>rating;

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

    public Map<String, Integer> getRating() {
        return rating;
    }

}
