package com.flowcode;

public class Sofa {
    private String colour;
    private int seats;
    private String material;
    private String shape;
    private int weight;

    public Sofa(String colour, int seats, String material, String shape, int weight) {
        this.colour = colour;
        this.seats = seats;
        this.material = material;
        this.shape = shape;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public int getSeats() {
        return seats;
    }

    public String getMaterial() {
        return material;
    }

    public String getShape() {
        return shape;
    }

    public int getWeight() {
        return weight;
    }
}
