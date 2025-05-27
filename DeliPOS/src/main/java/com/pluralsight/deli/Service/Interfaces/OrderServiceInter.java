package com.pluralsight.deli.Service.Interfaces;

import com.pluralsight.deli.Model.Order;
public interface OrderServiceInter {
    double calculateTotal(Order order);
    checkOut(Order order);
    orderFormatt(Order order);

}
