package com.pluralsight.deli.util;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Product;
import com.pluralsight.deli.service.impl.OrderService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public List<Order> orders = new ArrayList<>();
    Random r = new Random();
    private OrderService orderServiceInter;
    String databaseFilepath = "src/receipts" + ".csv";
    public String getOrderNumber(){
        int r1 = r.nextInt(1000);
        String.valueOf(r1);
        String orderNumber = String.valueOf(r1);
        return orderNumber;
    }
    public void writeToFile(Order order){
        try (FileWriter writer = new FileWriter(databaseFilepath, true)) {
            writer.write(getOrderNumber() + "|" + String.format("%.2f", orderServiceInter.calculateTotal(order)) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void receiptGenerator(Order order){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        DateTimeFormatter ordNum = DateTimeFormatter.ofPattern("yyyyMMdd-hh:mm:ss");
        String ordNumFormat = today.format(ordNum);
        String formattedToday = today.format(formatter);
        String receiptPath = "src/receipts" + formattedToday + ".txt";

        try (FileWriter writer = new FileWriter(receiptPath)) {
                writer.write("Order Number: " + "ord-" + ordNumFormat+ "\n");
                writer.write("Items: \n");
                for(Product item: order.getItems()){
                    writer.write(item.productDetails() + "\n\n");
                }
                writer.write("Total: $" + String.format("%.2f",orderServiceInter.calculateTotal(order)) + "\n");
            }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



