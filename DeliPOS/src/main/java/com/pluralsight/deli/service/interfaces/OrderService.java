package com.pluralsight.deli.service.interfaces;

import com.pluralsight.deli.model.Order;

public interface OrderService {
    double calculateTotal(Order order);
     void checkOut(Order order);
    String orderFormatter(Order order);

}
