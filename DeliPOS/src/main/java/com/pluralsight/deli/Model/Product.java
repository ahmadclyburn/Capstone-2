package com.pluralsight.deli.Model;

public abstract class Product {
    protected double startingPrice;
    private String name;

    public Product(double startingPrice, String name) {
        this.startingPrice = startingPrice;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String productDetails();

    public abstract double calculateTotal();
}
