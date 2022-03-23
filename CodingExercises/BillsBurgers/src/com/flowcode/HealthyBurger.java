package com.flowcode;

public class HealthyBurger extends BaseBurger {

    private int cheese = 1;
    private int lettuce = 0;
    private int tomato = 0;
    private int onion = 0;
    private int carrots = 0;
    private int pickles = 0;
    private double priceTotal = getBasePrice();
    private double additionsTotal = 0;

    public HealthyBurger(String name, String meat) {
        super(name, "BROWN RYE BREAD", meat);


    }

    @Override
    public int getCheese() {
        return cheese;
    }

    @Override
    public int getLettuce() {
        return lettuce;
    }

    @Override
    public int getTomato() {
        return tomato;
    }

    @Override
    public int getOnion() {
        return onion;
    }

    public int getCarrots() {
        return carrots;
    }

    public int getPickles() {
        return pickles;
    }


    @Override
    public void addCheese(int numberOfCheeseSlices){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfCheeseSlices + " CHEESE NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
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

    @Override
    public void addLettuce(int numberOfLettuce){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfLettuce + " LETTUCE NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
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

    @Override
    public void addTomatoes(int numberOfTomatoSlices){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfTomatoSlices + " TOMATO(ES) NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
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

    @Override
    public void addOnions(int numberOfOnionSlices){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfOnionSlices + " ONION(S) NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
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

    public void addCarrots(int numberOfCarrotSlices){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfCarrotSlices + " CARROT(S) NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
            System.out.println("-------------------------------");
        } else {
            this.carrots += numberOfCarrotSlices;
            this.priceTotal = this.priceTotal + ((double) numberOfCarrotSlices * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfCarrotSlices * 0.25);
            System.out.println("\nCarrot Slices added: " + numberOfCarrotSlices);
            System.out.println("Carrot in burger: " + getCarrots());
            System.out.println("Cost: £" + ((double) numberOfCarrotSlices * 0.25));
            System.out.println("------------------------");
        }
    }

    public void addPickles(int numberOfPickleSlices){
        if((getNumberOfItemsAdded() + 1) >= 7){
            System.out.println(numberOfPickleSlices + " PICKLE(S) NOT ADDED");
            System.out.println("MAX NUMBER OF ADDITIONS IS 6");
            System.out.println("-------------------------------");
        } else {
            this.pickles += numberOfPickleSlices;
            this.priceTotal = this.priceTotal + ((double) numberOfPickleSlices * 0.25);
            this.additionsTotal = this.additionsTotal + ((double) numberOfPickleSlices * 0.25);
            System.out.println("\nPickle Slices added: " + numberOfPickleSlices);
            System.out.println("Pickle in burger: " + getPickles());
            System.out.println("Cost: £" + ((double) numberOfPickleSlices * 0.25));
            System.out.println("------------------------");
        }
    }

    @Override
    public double getPriceTotal() {
        return priceTotal;
    }

    @Override
    public double getAdditionsTotal() {
        return this.additionsTotal;
    }

    @Override
    public int getNumberOfItemsAdded() {
        int numberOfItemsAdded = (getCheese() + getOnion() + getTomato() + getLettuce() + getPickles() + getCarrots())  - 1;
        return numberOfItemsAdded;
    }


}
