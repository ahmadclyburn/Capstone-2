package com.pluralsight.deli.Model;

public class Chips extends Product{

    public Chips(double startingPrice, String name) {
        super(startingPrice, name);
    }

    public double calculateTotal(){
        return 1.50;
   }
public String productDetails(){
    return " " + getName() + String.format(" $%.2f", calculateTotal());
}
}
