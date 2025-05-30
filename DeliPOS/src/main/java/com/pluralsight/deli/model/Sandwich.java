package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    protected SandwichSize size;
    protected BreadType breadType;
    protected List<RegularTopping> regularToppings;
    protected List<PremiumTopping> premiumToppings;
    protected List<Sauce> sauces;
    protected boolean isToasted;
    protected boolean extraMeat;
    protected boolean extraCheese;

    public Sandwich(String name, SandwichSize size, BreadType breadType,
                    boolean isToasted) {
        super(name, 0);
        this.size = size;
        this.breadType = breadType;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.isToasted = isToasted;
        this.extraMeat = false;

        if (size == SandwichSize.SMALL) {
            this.startingPrice = 5.50;
        } else if (size == SandwichSize.MEDIUM) {
            this.startingPrice = 7.00;
        } else if (size == SandwichSize.LARGE) {
            this.startingPrice = 8.50;
        }
    }

    public Sandwich(String name, SandwichSize size, BreadType breadType,
                    boolean isToasted, List<RegularTopping> regularToppings, List<PremiumTopping> premiumToppings, List<Sauce> sauces) {
        super(name, 0);
        this.size = size;
        this.breadType = breadType;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
        this.isToasted = isToasted;
        this.sauces = sauces;
        this.extraMeat = false;

        if (size == SandwichSize.SMALL) {
            this.startingPrice = 5.50;
        } else if (size == SandwichSize.MEDIUM) {
            this.startingPrice = 7.00;
        } else if (size == SandwichSize.LARGE) {
            this.startingPrice = 8.50;
        }
    }



    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public List<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public List<PremiumTopping> getPremiumToppings() {
        return premiumToppings;
    }

    public boolean isToasted() {
        return isToasted;
    }


    public boolean isExtraMeat() {
        return extraMeat;
    }

    @Override
    public double calculateProductTotal() {
        double total = startingPrice; //product total
        for (PremiumTopping topping : premiumToppings) { //iterating through premium toppings
            if (topping.getType() == PremiumTopping.Type.MEAT) { //conditional one if the topping is meat
                if (size == SandwichSize.SMALL) {
                    total += 1.00;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 2.00;
                } else if (size == SandwichSize.LARGE) {
                    total += 3.00;
                }
            } else if (topping.getType() == PremiumTopping.Type.CHEESE) {
                if (size == SandwichSize.SMALL) {
                    total += 0.75;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 1.50;
                } else if (size == SandwichSize.LARGE) {
                    total += 2.25;
                }
            }
        }

        if (extraMeat) {
            if (size == SandwichSize.SMALL) {
                total += 0.50;
            } else if (size == SandwichSize.MEDIUM) {
                total += 1.00;
            } else if (size == SandwichSize.LARGE) {
                total += 1.50;
            }
        }

        if (extraCheese) {
            if (size == SandwichSize.SMALL) {
                total += 0.30;
            } else if (size == SandwichSize.MEDIUM) {
                total += 0.60;
            } else if (size == SandwichSize.LARGE) {
                total += 0.90;
            }
        }
        return total;
    }

    @Override
    public String productDetails() {
        StringBuilder details = new StringBuilder(name + "    " + String.format("$%.2f", calculateProductTotal()) + " \n"
                + size + "\n    Bread Type: " + breadType + "\n    Toasted: " + isToasted +  "\n    Regular Toppings: ");
        for (RegularTopping topping : regularToppings) {
            details.append(topping).append(", ");
        }
        details.append("\n    Premium Toppings: ");
        for (PremiumTopping topping : premiumToppings) {
            details.append(topping).append(", ");
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

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addPremiumTopping(PremiumTopping topping) {
        premiumToppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
}
