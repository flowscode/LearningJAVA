package com.flowcode;

public class Television {
    private String manufacturer;
    private String screenSize;
    private int weight;
    private char energyClass;
    private boolean fourK;
    private Size size;
    private Resolution resolution;

    public Television(String manufacturer, String screenSize, int weight, char energyClass, boolean fourK, Size size, Resolution resolution) {
        this.manufacturer = manufacturer;
        this.screenSize = screenSize;
        this.weight = weight;
        this.energyClass = energyClass;
        this.fourK = fourK;
        this.size = size;
        this.resolution = resolution;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public int getWeight() {
        return weight;
    }

    public char getEnergyClass() {
        return energyClass;
    }

    public boolean isFourK() {
        return fourK;
    }

    public Size getSize() {
        return size;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void tvPowerButton(boolean onOrOff){
        if (onOrOff){
            System.out.println("TV [ON]");
        }

        if (!(onOrOff)){
            System.out.println("TV [OFF]");
        }
    }
}
