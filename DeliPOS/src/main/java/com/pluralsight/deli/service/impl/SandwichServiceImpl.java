package com.pluralsight.deli.service.impl;

import com.pluralsight.deli.controller.MenuPrompts;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.service.interfaces.SandwichService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SandwichServiceImpl implements SandwichService {
    private final Scanner scanner;

    public SandwichServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Sandwich createSandwich() {
        boolean isSignature = isSignature();
        if (isSignature) {
            return selectSignature();
        }
        SandwichSize size = selectSandwichSize();
        BreadType breadType = selectBreadType();
        boolean isToasted = isToasted();
        Sandwich sandwich = new Sandwich("Custom Sandwich", size, breadType, isToasted);
        selectPremiumToppings(sandwich);
        selectRegularToppings(sandwich);
        selectSauces(sandwich);
        extraMeat(sandwich);
        extraCheese(sandwich);
        return sandwich;
    }


    private boolean isSignature() {
        while (true) {
            System.out.println("Would you like to order a signature sandwich? (1: Yes, 2: No): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private Sandwich selectSignature() {
        while (true) {
            System.out.println("Enter Signature Sandwich (1: BLT, 2: Philly Cheese): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<PremiumTopping> premiumToppings = List.of(PremiumTopping.BACON, PremiumTopping.CHEDDAR_CHEESE);
                    List<RegularTopping> regularToppings = List.of(RegularTopping.LETTUCE, RegularTopping.TOMATOES);
                    List<Sauce> sauces = List.of(Sauce.RANCH);
                    return new Sandwich("BLT", SandwichSize.MEDIUM, BreadType.WHITE, true, regularToppings, premiumToppings, sauces);
                case "2":
                    List<PremiumTopping> premToppings = List.of(PremiumTopping.STEAK, PremiumTopping.AMERICAN_CHEESE);
                    List<RegularTopping> regToppings = List.of(RegularTopping.PEPPERS);
                    List<Sauce> sauceList = List.of(Sauce.MAYO);
                    return new Sandwich("Philly Cheese", SandwichSize.MEDIUM, BreadType.WHITE, true, regToppings, premToppings, sauceList);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private SandwichSize selectSandwichSize() {
        while (true) {
            System.out.println("Enter Sandwich Size (1: Small, 2: Medium, 3: Large): ");
            String sizeChoice = scanner.nextLine();
            switch (sizeChoice) {
                case "1":
                    return SandwichSize.SMALL;
                case "2":
                    return SandwichSize.MEDIUM;
                case "3":
                    return SandwichSize.LARGE;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean isToasted() {
        while (true) {
            System.out.println("Would you like your sandwich toasted? (1: Yes, 2: No): ");
            String choice = scanner.nextLine();
            if (Objects.equals(choice, "1")) {
                return true;
            } else if (Objects.equals(choice, "2")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private BreadType selectBreadType() {
        while (true) {
            System.out.print("Enter Bread Type (1: White, 2: Wheat, 3: Rye): ");
            String breadChoice = scanner.nextLine();
            BreadType breadType = switch (breadChoice) {
                case "1" -> BreadType.WHITE;
                case "2" -> BreadType.WHEAT;
                case "3" -> BreadType.RYE;
                default -> null;
            };
            if (breadType != null) {
                return breadType;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void selectRegularToppings (Sandwich sandwich){
        boolean done = false;
        while (!done) {
            System.out.print(MenuPrompts.getRegularToppings());
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                done = true;
            } else {
                RegularTopping topping = switch (choice) {
                    case "1" -> RegularTopping.LETTUCE;
                    case "2" -> RegularTopping.PEPPERS;
                    case "3" -> RegularTopping.ONIONS;
                    case "4" -> RegularTopping.TOMATOES;
                    case "5" -> RegularTopping.JALAPENOS;
                    case "6" -> RegularTopping.CUCUMBERS;
                    case "7" -> RegularTopping.PICKLES;
                    case "8" -> RegularTopping.GUACAMOLE;
                    case "9" -> RegularTopping.MUSHROOMS;
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        yield null;
                    }
                };
                if (topping != null && !sandwich.getRegularToppings().contains(topping)) {
                    sandwich.addRegularTopping(topping);
                }
            }
        }
    }


    private void selectPremiumToppings (Sandwich sandwich){
        boolean done = false;
        while (!done) {
            System.out.print(MenuPrompts.getPremiumToppings());
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                done = true;
            } else {
                PremiumTopping topping = switch (choice) {
                    case "1" -> PremiumTopping.STEAK;
                    case "2" -> PremiumTopping.HAM;
                    case "3" -> PremiumTopping.SALAMI;
                    case "4" -> PremiumTopping.ROAST_BEEF;
                    case "5" -> PremiumTopping.CHICKEN;
                    case "6" -> PremiumTopping.BACON;
                    case "7" -> PremiumTopping.AMERICAN_CHEESE;
                    case "8" -> PremiumTopping.SWISS_CHEESE;
                    case "9" -> PremiumTopping.PROVOLONE_CHEESE;
                    case "10" -> PremiumTopping.CHEDDAR_CHEESE;
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        yield null;
                    }
                };
                if (topping != null && !sandwich.getPremiumToppings().contains(topping)) {
                    sandwich.addPremiumTopping(topping);
                }
            }
        }
    }

    private void selectSauces (Sandwich sandwich){
        boolean done = false;
        while (!done) {
            System.out.print(MenuPrompts.getSauces());
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                done = true;
            } else {
                Sauce sauce = switch (choice) {
                    case "1" -> Sauce.MAYO;
                    case "2" -> Sauce.MUSTARD;
                    case "3" -> Sauce.KETCHUP;
                    case "4" -> Sauce.RANCH;
                    case "5" -> Sauce.THOUSAND_ISLAND;
                    case "6" -> Sauce.VINAIGRETTE;
                    case "7" -> Sauce.AU_JUS;
                    case "0" -> null;
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        yield null;
                    }
                };
                if (sauce != null) {
                    sandwich.addSauce(sauce);
                }
            }
        }
    }

    private void extraMeat(Sandwich sandwich){
        while (true) {
            System.out.print("Would you like extra meat? (1: Yes, 2: No): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                sandwich.setExtraMeat(true);
                return;
            } else if (choice.equals("2")) {
                sandwich.setExtraMeat(false);
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void extraCheese(Sandwich sandwich){
        while (true) {
            System.out.print("Would you like extra cheese? (1: Yes, 2: No): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                sandwich.setExtraCheese(true);
                return;
            } else if (choice.equals("2")) {
                sandwich.setExtraCheese(false);
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}