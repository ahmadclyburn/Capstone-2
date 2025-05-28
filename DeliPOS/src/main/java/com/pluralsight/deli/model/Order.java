package com.pluralsight.deli.model;

import com.pluralsight.deli.util.DataManager;

import java.util.List;

public class Order{
    private final String orderNumber;
    private List<Product> items;
    private static final DataManager dataManager = new DataManager();

    public Order(String orderNumber, List<Product> items) {
        this.orderNumber = orderNumber;
        this.items = items;
    }
    public void addItem (Product item){

    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getItems() {
        return items;
    }
}
