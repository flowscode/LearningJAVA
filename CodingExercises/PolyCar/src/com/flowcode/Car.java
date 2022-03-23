package com.flowcode;

public class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private int doors;
    private int seats;
    private boolean engine;

    public Car(String name, int cylinders, int doors, int seats) {
        this.name = name;
        this.cylinders = cylinders;
        this.doors = doors;
        this.seats = seats;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isEngine() {
        return engine;
    }

    public void startEngine(){
        System.out.println(getName() + " engine started");
        System.out.println("CLASS: CAR");
    }

    public void accelerate(){
        System.out.println(getName() + " has accelerated");
        System.out.println("CLASS: CAR");
    }

    public void pressBreak(){
        System.out.println(getName() + " has braked");
        System.out.println("CLASS: CAR");
    }

}
