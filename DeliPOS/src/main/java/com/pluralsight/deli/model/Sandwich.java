package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{
    private BreadType breadType;
    private Size size;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Topping> toppings;
    private List<Sauce> sauces;
    private boolean isToasted;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich() {
        super();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.extraMeat = false;
        this.extraCheese = false;

        if (size == Size.SMALL){
            this.startingPrice = 5.50;
        }else if(size == Size.MEDIUM){
            this.startingPrice = 7.00;
        } else if (size == Size.LARGE) {
            this.startingPrice = 8.50;
        }
    }

    public Sandwich(String name, BreadType breadType, Size size, List<Meat> meat, List<Cheese> cheeses,
                    List<Topping> toppings, List<Sauce> sauces, boolean isToasted) {
        super(0, name);
        this.breadType = breadType;
        this.size = size;
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.meats = new ArrayList<>();
        this.isToasted = isToasted;
        this.extraMeat = false;
        this.extraCheese = false;

        if (size == Size.SMALL){
            this.startingPrice = 5.50;
        }else if(size == Size.MEDIUM){
            this.startingPrice = 7.00;
        } else if (size == Size.LARGE) {
            this.startingPrice = 8.50;
        }
    }

    public Size getSize() {
        return size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public double calculateTotal(){
       double total = startingPrice;
        return total;
    }

    @Override
    public String productDetails() {
        StringBuilder details = new StringBuilder( "    " + String.format("$%.2f", calculateTotal()) + " \n"
                + size + "\n    Bread Type: " + breadType + "\n    Toasted: " + isToasted +  "\n    Regular Toppings: ");
        for (Topping topping : toppings) {
            details.append(topping).append(", ");
        }
        details.append("\n           Toppings: ");
        for (Meat meat : meats) {
            details.append(meat).append(", ");
        }
        if(extraMeat) {
            details.append("\n    Extra Meat: Yes");
        } else {
            details.append("\n    Extra Meat: No");
        }
        details.append("\n    Sauces: ");
        for (Sauce sauce : sauces) {
            details.append(sauce).append(", ");
        }
        return details.toString();
    }

    public void addMeat(List<Meat> meat) {

    }

    public void addCheese(List<Cheese> cheeses){

    }

    public void addSauces(List<Sauce> sauces){

    }

    public void addToppings (List<Cheese> toppings) {

    }

    public void setIsToasted(boolean isToasted){

    }

    public void setExtraMeat(boolean extraMeat){

    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
}
