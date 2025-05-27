package com.pluralsight.deli.Service.Interfaces;

import com.pluralsight.deli.Model.Order;
public interface OrderServiceInter {
    double calculateTotal(Order order);
    void checkOut(Order order);
    String orderFormatt(Order order);

}
