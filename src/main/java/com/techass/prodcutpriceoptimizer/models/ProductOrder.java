package com.techass.prodcutpriceoptimizer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOrder {

    private final int productId;

    private final int units;

    public ProductOrder(@JsonProperty("productId") int productId, @JsonProperty("units") int units) {
        this.productId = productId;
        this.units = units;
    }

    public int getProductId() {
        return productId;
    }

    public int getUnits() {
        return units;
    }
}
