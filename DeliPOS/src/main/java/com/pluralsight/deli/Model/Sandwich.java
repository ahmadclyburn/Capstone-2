package com.pluralsight.deli.Model;

import com.pluralsight.deli.Enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{
    private BreadType breadType;
    private Size size;
    private List<Meats> meat;
    private List<Cheeses> cheeses;
    private List<Toppings> toppings;
    private List<Sauces> sauces;
    private boolean isToasted;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String name, BreadType breadType, Size size, List<Meats> meat, List<Cheeses> cheeses,
                    List<Toppings> toppings, List<Sauces> sauces, boolean isToasted) {
        super(0, name);
        this.breadType = breadType;
        this.size = size;
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.meat = new ArrayList<>();
        this.isToasted = isToasted;
        this.extraMeat = false;

        if (size == Size.SMALL){
            this.startingPrice = 5.50;
        }else if(size == Size.MEDIUM){
            this.startingPrice = 7.00;
        } else if (size == Size.LARGE) {
            this.startingPrice = 8.50;
        }
    }

    public double calculateTotal(){
       double total = startingPrice;
        return total;
    }
    public String productDetails(){
        return;
    }
    public void addMeat(List<Meats> meat) {

    }
    public void addCheese(List<Cheeses> cheeses){

    }
    public void addSauces(List<Sauces> sauces){

    }
    public void addToppings (List<Cheeses> toppings) {

    }
    public void setIsToasted(boolean isToasted){

    }
    public void setExtraMeat(boolean extraMeat){

    }

}
