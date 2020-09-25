package com.techass.prodcutpriceoptimizer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {

    private final int Id;

    private final List<ProductOrder> order;

    public Order( @JsonProperty("id")  int id, @JsonProperty("order") List<ProductOrder> order) {
        Id = id;
        this.order = order;
    }

    public int getId() {
        return Id;
    }

    public List<ProductOrder> getOrder() {
        return order;
    }
}
