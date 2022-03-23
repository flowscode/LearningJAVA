package com.flowcode;

public class BMW extends Car{
    public BMW(String name, int cylinders, int doors, int seats) {
        super(name, cylinders, doors, seats);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getCylinders() {
        return super.getCylinders();
    }

    @Override
    public int getWheels() {
        return super.getWheels();
    }

    @Override
    public int getDoors() {
        return super.getDoors();
    }

    @Override
    public int getSeats() {
        return super.getSeats();
    }

    @Override
    public boolean isEngine() {
        return super.isEngine();
    }

    @Override
    public void startEngine(){
        System.out.println(getName() + " engine started");
        System.out.println("CLASS: BMW");
    }

    @Override
    public void accelerate(){
        System.out.println(getName() + " has accelerated");
        System.out.println("CLASS: BMW");
    }

    @Override
    public void pressBreak(){
        System.out.println(getName() + " has braked");
        System.out.println("CLASS: BMW");
    }
}
