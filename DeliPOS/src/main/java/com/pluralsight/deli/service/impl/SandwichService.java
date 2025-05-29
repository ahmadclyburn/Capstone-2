package com.pluralsight.deli.service.impl;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.service.interfaces.SandwichServiceInter;


import java.util.List;
import java.util.Scanner;

public class SandwichService implements SandwichServiceInter {
    public Scanner input =new Scanner(System.in);

    @Override
    public Sandwich createSandwich() {
        boolean isSignature = isSignature();
        if (isSignature) {
            return selectSignature();
        }
        Size size = selectSandwichSize();
        BreadType breadType = selectBreadType();
        boolean isToasted = isToasted();
        Sandwich sandwich = new Sandwich();
        selectMeat(sandwich);
        selectCheese(sandwich);
        selectToppings(sandwich);
        selectSauces(sandwich);
        extraCheese(sandwich);
        extraMeat(sandwich);
        return sandwich;
    }

    private boolean isSignature(){
        while(true) {
            System.out.println("would you like a signature sandwhich? (1: yes, 2: no): ");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("invalid option, please try again.");
            }
        }

    }
    private Sandwich selectSignature() {
       while(true){ System.out.println("enter signature sandwhich(1:BLT or 2:Philly Cheese): ");
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                List<Meat> meats = List.of(Meat.BACON);
                List<Cheese> cheeses = List.of(Cheese.CHEDDAR_CHEESE);
                List<Sauce> sauces = List.of(Sauce.RANCH);
                List<Topping> toppings = List.of(Topping.LETUCE, Topping.TOMATOES);
                return new Sandwich("BLT", BreadType.WHITE, Size.MEDIUM, meats, cheeses, toppings, sauces, true);
            case "2":
                List<Meat> meats1 = List.of(Meat.STEAK);
                List<Cheese> cheeses1 = List.of(Cheese.AMERICAN_CHEESE);
                List<Sauce> sauces1 = List.of(Sauce.MAYO);
                List<Topping> toppings1 = List.of(Topping.PEPPERS);
                return new Sandwich("Philly Cheese Steak", BreadType.WHITE, Size.MEDIUM, meats1, cheeses1, toppings1, sauces1, true);
            default:
                System.out.println("invalid choice, try again");
        }
    }
    }
    private Size selectSandwichSize(){
        while(true){System.out.println("select a size");
        String sizeChoice = input.nextLine();
        switch (sizeChoice){
            case"1":
                return Size.SMALL;
            case"2":
                return Size.MEDIUM;
            case"3":
                return Size.LARGE;
            default:
                System.out.println("invalid choice, try again");
        }
    }

    }
    private BreadType selectBreadType(){
        while (true) {System.out.println("select a bread type");
        String breadChoice = input.nextLine();
        switch (breadChoice){
            case"1":
                return BreadType.WHITE;
            case"2":
                return BreadType.WHEAT;
            case"3":
                return BreadType.RYE;
            case"4":
                return BreadType.WRAP;
            default:
                System.out.println("invalid choice, try again");
        }

        }
    }
    private boolean isToasted(){
        while (true){
            System.out.println("would you like your sadnwich toasted");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("yes")){
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                return false;
            }else{
                System.out.println("invalid, try again.");
            }
        }
    }
    private Meat selectMeat(Sandwich sandwich){
        while (true) {System.out.println("select a meat");
            String meatsChoice = input.nextLine();
            switch (meatsChoice){
                case"1":
                    return Meat.BACON;
                case"2":
                    return Meat.CHICKEN;
                case"3":
                    return Meat.HAM;
                case"4":
                    return Meat.STEAK;
                case"5":
                    return Meat.SALAMI;
                case"6":
                    return Meat.ROAST_BEEF;
                default:
                    System.out.println("invalid choice, try again");
    }}}

    private Cheese selectCheese(Sandwich sandwich){
        while (true) {System.out.println("select a cheese");
            String cheeseChoice = input.nextLine();
            switch (cheeseChoice){
                case"1":
                    return Cheese.AMERICAN_CHEESE;
                case"2":
                    return Cheese.PROVOLONE_CHEESE;
                case"3":
                    return Cheese.CHEDDAR_CHEESE;
                case"4":
                    return Cheese.SWISS_CHEESE;
                default:
                    System.out.println("invalid choice, try again");
    }}}
    private Topping selectToppings(Sandwich sandwich){
        while (true) {System.out.println("select a topping");
            String breadChoice = input.nextLine();
            switch (breadChoice){
                case"1":
                    return Topping.LETUCE;
                case"2":
                    return Topping.PEPPERS;
                case"3":
                    return Topping.CUCUMBERS;
                case"4":
                    return Topping.TOMATOES;
                case"5":
                    return Topping.JALEPENOS;
                case"6":
                    return Topping.GUACAMOLE;
                case"7":
                    return Topping.MUSHROOMS;
                case"8":
                    return Topping.PICKLES;
                case"9":
                    return Topping.ONIONS;
                default:
                    System.out.println("invalid choice, try again");
    }}}
    private Sauce selectSauces(Sandwich sandwich){
        while (true) {System.out.println("select a sauce");
            String sauceChoice = input.nextLine();
            switch (sauceChoice){
                case"1":
                    return Sauce.MAYO;
                case"2":
                    return Sauce.KETCHUP;
                case"3":
                    return Sauce.RANCH;
                case"4":
                    return Sauce.VINAIGRETTE;
                case"5":
                    return Sauce.THOUSAND_ISLAND;
                case"6":
                    return Sauce.MUSTARD;
                default:
                    System.out.println("invalid choice, try again");
    }}}
    private boolean extraCheese(Sandwich sandwich){
        while(true){System.out.println("would you like  extra cheese?");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("yes")){
            sandwich.setExtraCheese(true);
        } else if (choice.equalsIgnoreCase("no")) {
            sandwich.setExtraCheese(false);
        }else{
            System.out.println("invalid, try again.");
        }
    }
    }
    private boolean extraMeat(Sandwich sandwich){
        while(true){System.out.println("would you like  extra meat?");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("yes")){
            sandwich.setExtraMeat(true);
        } else if (choice.equalsIgnoreCase("no")) {
            sandwich.setExtraMeat(false);
        }else{
            System.out.println("invalid, try again.");
        }

    }}

}