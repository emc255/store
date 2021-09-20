package com.emc;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        List<Product> exp = store.getProductsBeforeExpiration(LocalDateTime.of(2000,4,10,12,0));
        printProducts(exp);
        System.out.println();

        //printProducts(store.getProducts());
    }

    public static void printProducts(List<Product> products) {
        for (Product prod: products) {
            System.out.println("Title: " +prod.getTitle());
            System.out.println("Rate: " +prod.getRating().getRate());
            System.out.println("Delivery: " +prod.getDeliverDate());
            System.out.println("Expiration: " +prod.getExpirationDate());
            System.out.println("=================================");
        }
    }
}
