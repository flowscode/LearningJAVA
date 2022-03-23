package com.flowcode;

public class Speakers {
    private String manufacturer;
    private String colour;
    private int numberOfSpeakers;
    private int watts;

    public Speakers(String manufacturer, String colour, int numberOfSpeakers, int watts) {
        this.manufacturer = manufacturer;
        this.colour = colour;
        this.numberOfSpeakers = numberOfSpeakers;
        this.watts = watts;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColour() {
        return colour;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public int getWatts() {
        return watts;
    }

    public void speakerPowerButton(boolean onOrOff){
        if (onOrOff){
            System.out.println("Speaker [ON]");
        }

        if (!(onOrOff)){
            System.out.println("Speaker [OFF]");
        }
    }
}
