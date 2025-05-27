package com.pluralsight.deli.Service.Impl;

import com.pluralsight.deli.Enums.DrinkSize;
import com.pluralsight.deli.Model.Drinks;
import com.pluralsight.deli.Service.Interfaces.DrinkServiceInter;

import java.util.Scanner;

public class DrinkService implements DrinkServiceInter {

    public Scanner input =new Scanner(System.in);

    public Drinks selectDrink() {
        String choice = input.nextLine();
        String drinkFlavor;
        switch (choice) {
            case "1":
                drinkFlavor = "dr. pepper";
                break;
            case "2":
                drinkFlavor = "lemonade";
                break;
            case "3":
                drinkFlavor = "water";
                break;
            case "4":
                drinkFlavor = "mt. dew";
                break;
            default:
                System.out.println("invalid choice");
                return null;

        }
        DrinkSize drinkSize;
        String sizeChoice = input.nextLine();
        switch (sizeChoice){
            case "1":
                drinkSize = DrinkSize.SMALL;
                break;
            case "2":
                drinkSize = DrinkSize.MEDIUM;
                break;
            case "3":
                drinkSize = DrinkSize.LARGE;
                break;
            default:
                System.out.println("invalid choice");
                return null;
        }
        return new Drinks(drinkFlavor, drinkSize);
    }
}
