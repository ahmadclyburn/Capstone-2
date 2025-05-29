package com.pluralsight.deli.service.impl;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Product;
import com.pluralsight.deli.service.interfaces.OrderServiceInter;
import com.pluralsight.deli.util.DataManager;

import java.util.Scanner;

public class OrderService implements OrderServiceInter{
    private DataManager dataManager;
    public Scanner input =new Scanner(System.in);

    @Override
    public double calculateTotal(Order order){
        double total = 0;
        for (Product item :order.getItems()){
            total += item.calculateTotal();
        }
        return total;
    }
    @Override
    public void checkOut(Order order){
        System.out.println("Order Summary:");
        for (Product item : order.getItems()) {
            System.out.println(item.productDetails());}
        double total = calculateTotal(order);
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("Thank you for your order, " + "!\n════════════════════════" +
                "══════════════════════════════════════════════════════════════════════════════" +
                "═══════════════════════════════════════════\n\n\n\n\n\n\n\n\n\n");
        dataManager.writeToFile(order);
        dataManager.receiptGenerator(order);
    }

    @Override
    public String orderFormatter(Order order) {
        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("╔════════════════════════════════════════════════════╗\n");
        orderSummary.append("║                    Order Summary                   ║\n");
        orderSummary.append("╠════════════════════════════════════════════════════╣\n");
        for (Product item : order.getItems()) {
            String itemName = item.getName();
            String itemPrice = String.format("$%.2f", item.calculateTotal());
            orderSummary.append(String.format("║ %-43s %6s ║\n", itemName, itemPrice));
        }
        orderSummary.append("╠════════════════════════════════════════════════════╣\n");
        double total = calculateTotal(order);
        orderSummary.append(String.format("║ %-43s %6s ║\n", "Total:", String.format("$%.2f", total)));
        orderSummary.append("╚════════════════════════════════════════════════════╝\n");
        return orderSummary.toString();
    }
    }