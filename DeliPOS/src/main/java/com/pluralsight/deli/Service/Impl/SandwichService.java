package com.pluralsight.deli.Service.Impl;

import com.pluralsight.deli.Enums.*;
import com.pluralsight.deli.Model.Sandwich;
import com.pluralsight.deli.Service.Interfaces.SandwichServiceInter;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
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
        Sandwich sandwich = new Sandwich("custom Sandwich", size, breadType, isToasted);
        selectMeat(sandwich);
        selectCheese(sandwich);
        selectToppings(sandwich);
        selectSauces(sandwich);
        extraCheese(sandwich);
        extraMeat(sandwich);
        return sandwich;
    }

    private boolean isSignature(){
        while(true){
            System.out.println("would you like a signature sandwhich? (1: yes, 2: no): ");
            String choice = input.nextLine();
            if (choice.equals("1")){
                return true;
            }else if(choice.equals("2")){
                return false;
            }else{
                System.out.println("invalid option, please try again.");
            }
            }

    }
    private Sandwich selectSignature(){
        System.out.println("enter signature sandwhich(1:BLT or 2:Philly Cheese): ");
        String choice = input.nextLine();
        switch(choice){
            case"1":
                List<Meats> meats = List.of(Meats.BACON);
                List<Cheeses> cheeses = List.of(Cheeses.CHEDDAR_CHEESE);
                List<Sauces> sauces = List.of(Sauces.RANCH);
                List<Toppings> toppings = List.of(Toppings.LETUCE, Toppings.TOMATOES)
                return new Sandwich("BLT",BreadType.WHITE, Size.MEDIUM,meats, cheeses, toppings, sauces, true);
            case "2":
                List<Meats> meats1 = List.of(Meats.STEAK);
                List<Cheeses> cheeses1  =List.of(Cheeses.AMERICAN_CHEESE);
                List<Sauces> sauces1 = List.of(Sauces.MAYO);
                List<Toppings> toppings1 = List.of(Toppings.PEPPERS);
                return new Sandwich("Philly Cheese Steak", BreadType.WHITE, Size.MEDIUM, meats1, cheeses1, toppings1, sauces1, true);
            default:
                System.out.println("invalid choice, try again");
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
        while (true) {System.out.println("select a a bread type");
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
    private Meats selectMeat(Sandwich sandwich){
        while (true) {System.out.println("select a meat");
            String meatsChoice = input.nextLine();
            switch (meatsChoice){
                case"1":
                    return Meats.BACON;
                case"2":
                    return Meats.CHICKEN;
                case"3":
                    return Meats.HAM;
                case"4":
                    return Meats.STEAK;
                case"5":
                    return Meats.SALAMI;
                case"6":
                    return Meats.ROAST_BEEF;
                default:
                    System.out.println("invalid choice, try again");
    }}}

    private Cheeses selectCheese(Sandwich sandwich){
        while (true) {System.out.println("select a cheese");
            String cheeseChoice = input.nextLine();
            switch (cheeseChoice){
                case"1":
                    return Cheeses.AMERICAN_CHEESE;
                case"2":
                    return Cheeses.PROVOLONE_CHEESE;
                case"3":
                    return Cheeses.CHEDDAR_CHEESE;
                case"4":
                    return Cheeses.SWISS_CHEESE;
                default:
                    System.out.println("invalid choice, try again");
    }}}
    private Toppings selectToppings(Sandwich sandwich){
        while (true) {System.out.println("select a topping");
            String breadChoice = input.nextLine();
            switch (breadChoice){
                case"1":
                    return Toppings.LETUCE;
                case"2":
                    return Toppings.PEPPERS;
                case"3":
                    return Toppings.CUCUMBERS;
                case"4":
                    return Toppings.TOMATOES;
                case"5":
                    return Toppings.JALEPENOS;
                case"6":
                    return Toppings.GUACAMOLE;
                case"7":
                    return Toppings.MUSHROOMS;
                case"8":
                    return Toppings.PICKLES;
                case"9":
                    return Toppings.ONIONS;
                default:
                    System.out.println("invalid choice, try again");
    }}}
    private Sauces selectSauces(Sandwich sandwich){
        while (true) {System.out.println("select a sauce");
            String sauceChoice = input.nextLine();
            switch (sauceChoice){
                case"1":
                    return Sauces.MAYO;
                case"2":
                    return Sauces.KETCHUP;
                case"3":
                    return Sauces.RANCH;
                case"4":
                    return Sauces.VINAIGRETTE;
                case"5":
                    return Sauces.THOUSAND_ISLAND;
                case"6":
                    return Sauces.MUSTARD;
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