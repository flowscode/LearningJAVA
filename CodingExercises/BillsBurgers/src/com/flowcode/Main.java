package com.flowcode;

public class Main {

    public static void main(String[] args) {
        BaseBurger joshBurger1 = new BaseBurger("Beef Burger","White Bread Roll", "Beef");
        HealthyBurger healthyBurger = new HealthyBurger("Vegan Burger","Vegan Chicken");
        DeluxeBurger deluxeBurger = new DeluxeBurger("Deluxe Meal","Italian Bread Roll","Chicken");


        System.out.println("\nNAME: " + joshBurger1.getName());
        joshBurger1.addLettuce(1);
        joshBurger1.addCheese(2);
        joshBurger1.addOnions(1);
        joshBurger1.addTomatoes(1);
        System.out.println("NAME: " + joshBurger1.getName());
        System.out.println("BREAD TYPE: " + joshBurger1.getBreadRollType());
        System.out.println("MEAT: " + joshBurger1.getMeat());
        System.out.println("BASE PRICE: £" + joshBurger1.getBasePrice());
        System.out.println("ADDITIONS: " + joshBurger1.getNumberOfItemsAdded() + " Items");
        System.out.println("ADDITIONAL COSTS: £" + joshBurger1.getAdditionsTotal());
        System.out.println("TOTAL: £" + joshBurger1.getPriceTotal());
        System.out.println("--------------------------\n");


        System.out.println("\nNAME: " + healthyBurger.getName());
        healthyBurger.addCheese(1);
        healthyBurger.addCarrots(1);
        healthyBurger.addOnions(2);
        healthyBurger.addTomatoes(2);
        healthyBurger.addPickles(1);
        System.out.println("NAME: " + healthyBurger.getName());
        System.out.println("BREAD TYPE: " + healthyBurger.getBreadRollType());
        System.out.println("MEAT: " + healthyBurger.getMeat());
        System.out.println("BASE PRICE: £" + healthyBurger.getBasePrice());
        System.out.println("ADDITIONS: " + healthyBurger.getNumberOfItemsAdded() + " Items");
        System.out.println("ADDITIONAL COSTS: £" + healthyBurger.getAdditionsTotal());
        System.out.println("TOTAL: £" + healthyBurger.getPriceTotal());
        System.out.println("--------------------------\n");

        System.out.println("\nNAME: " + deluxeBurger.getName());
        deluxeBurger.addLettuce(1);
        deluxeBurger.addCheese(2);
        deluxeBurger.addOnions(1);
        deluxeBurger.addTomatoes(1);
        System.out.println("NAME: " + deluxeBurger.getName());
        System.out.println("BREAD TYPE: " + deluxeBurger.getBreadRollType());
        System.out.println("MEAT: " + deluxeBurger.getMeat());
        System.out.println("CHIPS? " + deluxeBurger.isChips());
        System.out.println("DRINK? " + deluxeBurger.isDrink());
        System.out.println("BASE PRICE: £" + deluxeBurger.getBasePrice());
        System.out.println("ADDITIONS: " + deluxeBurger.getNumberOfItemsAdded() + " Items");
        System.out.println("ADDITIONAL COSTS: £" + deluxeBurger.getAdditionsTotal());
        System.out.println("TOTAL: £" + deluxeBurger.getPriceTotal());
        System.out.println("--------------------------\n");

        System.out.println("TOTAL: £" + joshBurger1.getPriceTotal());
        System.out.println("TOTAL: £" + healthyBurger.getPriceTotal());
        System.out.println("TOTAL: £" + deluxeBurger.getPriceTotal());

    }
}
