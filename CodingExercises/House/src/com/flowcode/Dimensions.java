package com.flowcode;

public class Dimensions {
   private double width;
   private double length;

    public Dimensions(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void getDimensions(){
        System.out.println(width + "," + length);
    }
}
