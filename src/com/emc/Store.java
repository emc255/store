package com.emc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final List<Product> products;

    public Store() {
        this.products = createProductList();
    }

    private List<Product> createProductList() {
        List<Product> products = new ArrayList<>();
        try {
            // Create a neat value object to hold the URL
            String url = "https://fakestoreapi.com/products";
            HttpClient client = HttpClient.newHttpClient();

            // create a request
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(url))
                    .build();

            // api response in string
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // changing the response to class
            ObjectMapper mapper = new ObjectMapper();
            List<ModelProduct> result = mapper.readValue(response.body(), new TypeReference<>() {
            });

            // Finally we have the response
            for (ModelProduct product: result) {
                products.add(new Product(product.getId(),product.getTitle(),product.getPrice(),product.getDescription(),product.getCategory(),product.getImage()));
            }

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getProductsBeforeExpiration (LocalDateTime date) {
        return products
                .stream()
                .filter(p -> p.expirationDate().isBefore(date))
                .collect(Collectors.toList());
    }

    public List<Product> getProducts() {
        return products;
    }
}
