package com.flowcode;

class BaseBurger {
    private String name;
    private String breadRollType;
    private String meat;
    private int cheese = 1;
    private int lettuce = 0;
    private int tomato = 0;
    private int onion = 0;
    private double basePrice = 3.00;
    private double priceTotal = basePrice;
    private double additionsTotal = 0;

    public BaseBurger(String name, String breadRollType, String meat) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public int getCheese() {
        return cheese;
    }

    public int getLettuce() {
        return lettuce;
    }

    public int getTomato() {
        return tomato;
    }

    public int getOnion() {
        return onion;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    public String getName() {
        return name;
    }

    public void addCheese(int numberOfCheeseSlices) {
        if ((getNumberOfItemsAdded() + 1) >= 5) {
            System.out.println(numberOfCheeseSlices + " CHEESE NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 4");
            System.out.println("-------------------------------");
        } else {
            this.cheese += numberOfCheeseSlices;
            this.priceTotal = this.priceTotal + ((double) numberOfCheeseSlices * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfCheeseSlices * 0.25);
            System.out.println("\nCheese added: " + numberOfCheeseSlices);
            System.out.println("Cheese in burger: " + getCheese());
            System.out.println("Cost: £" + ((double) numberOfCheeseSlices * 0.25));
            System.out.println("------------------------");
        }
    }

    public void addLettuce(int numberOfLettuce) {
        if ((getNumberOfItemsAdded() + 1) >= 5) {
            System.out.println(numberOfLettuce + " LETTUCE NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 4");
            System.out.println("-------------------------------");
        } else {
            this.lettuce += numberOfLettuce;
            this.priceTotal = this.priceTotal + ((double) numberOfLettuce * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfLettuce * 0.25);
            System.out.println("\nLettuce added: " + numberOfLettuce);
            System.out.println("Lettuce in burger: " + getLettuce());
            System.out.println("Cost: £" + ((double) numberOfLettuce * 0.25));
            System.out.println("------------------------");
        }
    }

    public void addTomatoes(int numberOfTomatoSlices) {
        if ((getNumberOfItemsAdded() + 1) >= 5) {
            System.out.println(numberOfTomatoSlices + " TOMATO NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 4");
            System.out.println("-------------------------------");
        } else {
            this.tomato += numberOfTomatoSlices;
            this.priceTotal = this.priceTotal + ((double) numberOfTomatoSlices * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfTomatoSlices * 0.25);
            System.out.println("\nTomato Slices added: " + numberOfTomatoSlices);
            System.out.println("Tomato in burger: " + getTomato());
            System.out.println("Cost: £" + ((double) numberOfTomatoSlices * 0.25));
            System.out.println("------------------------");
        }
    }

    public void addOnions(int numberOfOnionSlices) {
        if ((getNumberOfItemsAdded() + 1) >= 5) {
            System.out.println(numberOfOnionSlices + " ONION NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 4");
            System.out.println("-------------------------------");
        } else {
            this.onion += numberOfOnionSlices;
            this.priceTotal = this.priceTotal + ((double) numberOfOnionSlices * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfOnionSlices * 0.25);
            System.out.println("\nOnion Slices added: " + numberOfOnionSlices);
            System.out.println("Onion in burger: " + getOnion());
            System.out.println("Cost: £" + ((double) numberOfOnionSlices * 0.25));
            System.out.println("------------------------");
        }
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public double getAdditionsTotal() {
        return this.additionsTotal;
    }

    public int getNumberOfItemsAdded() {
        int numberOfItemsAdded = (getCheese() + getOnion() + getTomato() + getLettuce()) - 1;
        return numberOfItemsAdded;
    }

}
