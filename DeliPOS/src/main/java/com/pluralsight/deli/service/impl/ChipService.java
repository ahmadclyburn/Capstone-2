package com.pluralsight.deli.service.impl;

import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.service.interfaces.ChipServiceInter;

import java.util.Scanner;
public class ChipService implements ChipServiceInter {
    public Scanner input = new Scanner (System.in);
    public Chips selectChips(){
        String choice = input.nextLine();
        String chipsName;
        switch (choice){
            case "1":
                chipsName = "Doritos: cheddar";
                break;
            case "2":
                chipsName = "BBQ";
                break;
            case "3":
                chipsName = "Sour Cream & onion";
                break;
            case "4":
                chipsName = "lays original";
                break;
            case"5":
                chipsName = "Doritos: cool ranch";
                break;
            default:
                System.out.println("invalid choice");
                return null;
        }
        return new Chips(chipsName);
    }
}
