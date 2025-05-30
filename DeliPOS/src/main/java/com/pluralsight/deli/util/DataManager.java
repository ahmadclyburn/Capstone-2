package com.pluralsight.deli.util;

import com.pluralsight.deli.model.*;
import com.pluralsight.deli.service.impl.OrderServiceImpl;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    String databaseFilepath = "C:\\pluralsight\\Capstone-2\\DeliPOS\\src\\main\\resources\\transaction-history";
    private OrderServiceImpl orderService;
//    private List<Order> orders = new ArrayList<>(); // Initialize the orders list

    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public void receiptGenerator(Order order) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH-mm-ss");
        String ordNumFormat = today.format(formatter);
        String receiptDirectory = "C:\\pluralsight\\Capstone-2\\DeliPOS\\src\\main\\resources\\receipts";
        String receiptFilePath = receiptDirectory + "/receipt_" + ordNumFormat + ".txt";
        File directory = new File(receiptDirectory);
        if (!directory.exists()) {
            directory.mkdirs();}

        try (FileWriter writer = new FileWriter(receiptFilePath)) {
            writer.write("Order Number: " + "ord-" + ordNumFormat + "\n");
            writer.write("Customer Name: " + order.getCustomerName() + "\n");
            writer.write("Items: \n");
            for (Product item : order.getItems()) {
                writer.write(item.productDetails() + "\n\n");
            }
            writer.write("Total: $" + String.format("%.2f", orderService.calculateTotal(order)) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToDataFile(Order order) {
        try (FileWriter writer = new FileWriter(databaseFilepath, true)) {
            writer.write(getOrderNumber() + "|" + order.getCustomerName() + "|" + String.format("%.2f", orderService.calculateTotal(order)) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public void loadFromDatabase() {
//        // Load transactions
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(databaseFilepath));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split("[|]");
//                String orderNumber = data[0];
//                String customerName = data[1];
//                Order order = new Order(customerName);
//                orders.add(order);
//            }
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public String getOrderNumber() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hh-mm-ss");
        String formattedToday = today.format(formatter);
        return "ord-" + formattedToday;
    }
}

