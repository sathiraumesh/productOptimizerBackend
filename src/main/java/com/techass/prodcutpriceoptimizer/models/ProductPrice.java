package com.techass.prodcutpriceoptimizer.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonAutoDetect
public class ProductPrice {

    private final long id;

    private final String name;

    private final double price;

    public ProductPrice(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("price") double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
