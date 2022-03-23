package com.flowcode;

public class DeluxeBurger extends BaseBurger {

    private boolean chips = true;
    private boolean drink = true;
    private int cheese = 1;
    private int lettuce = 0;
    private int tomato = 0;
    private int onion = 0;
    private double priceTotal = getBasePrice();
    private double additionsTotal = 0;

    public DeluxeBurger(String name, String breadTypeString, String meat) {
        super(name, breadTypeString, meat);

    }

    public boolean isChips() {
        return chips;
    }

    public boolean isDrink() {
        return drink;
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


    @Override
    public void addCheese(int numberOfCheeseSlices){
        System.out.println("UNABLE TO ADD CHEESE TO THIS ORDER");
    }

    @Override
    public void addLettuce(int numberOfLettuce){
        System.out.println("UNABLE TO ADD LETTUCE TO THIS ORDER");
    }

    @Override
    public void addTomatoes(int numberOfTomatoSlices){
        System.out.println("UNABLE TO ADD TOMATO TO THIS ORDER");
    }

    @Override
    public void addOnions(int numberOfOnionSlices){
        System.out.println("UNABLE TO ADD TOMATO TO THIS ORDER");
    }


    @Override
    public double getPriceTotal() {
        return priceTotal;
    }

    @Override
    public double getBasePrice(){
        return 4.99;
    }

    @Override
    public double getAdditionsTotal() {
        return this.additionsTotal;
    }

    @Override
    public int getNumberOfItemsAdded() {
        int numberOfItemsAdded = (getCheese() + getOnion() + getTomato() + getLettuce()) - 1;
        return numberOfItemsAdded;
    }


}
