package com.pluralsight.deli.Model;

import com.pluralsight.deli.Enums.DrinkSize;

public class Drinks extends Product{
private final DrinkSize size;

    public Drinks(String name, DrinkSize size) {
        super(0, name);
        this.size = size;
    }

    public DrinkSize getSize() {
        return size;
    }

    @Override
    public double calculateTotal() {
        if (size == DrinkSize.SMALL){
            return 2.00;
        } else if (size == DrinkSize.MEDIUM) {
            return 2.50;
        } else if (size == DrinkSize.LARGE) {
            return 3.00;
        }
        return 0;
    }
    public String productDetails(){
        return getSize() + " " + getName() + String.format(" $%.2f", calculateTotal());    }

}
