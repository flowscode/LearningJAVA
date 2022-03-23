package com.flowcode;

import java.util.function.DoubleToIntFunction;

public class LivingRoom {
    private String colour;
    private String flooring;
    private Dimensions dimensions;
    private Television television;
    private Sofa sofa;
    private Speakers speakers;

    public LivingRoom(String colour, String flooring, Dimensions dimensions, Television television, Sofa sofa, Speakers speakers) {
        this.colour = colour;
        this.flooring = flooring;
        this.dimensions = dimensions;
        this.television = television;
        this.sofa = sofa;
        this.speakers = speakers;
    }

    public String getColour() {
        return colour;
    }

    public void paintRoom(String newColour){
        this.colour = newColour;
    }

    public void changeFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getFlooring() {
        return flooring;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Television getTelevision() {
        return television;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void speakerPowerButton(boolean option){
        if (option){
            System.out.println("turning on speaker");
            speakers.speakerPowerButton(true);
        }

        if (!(option)){
            System.out.println("turning off speaker");
            speakers.speakerPowerButton(false);
        }
    }

    public void tvPowerButton(boolean option){
        if (option){
            System.out.println("turning on TV");
            television.tvPowerButton(true);
        }

        if (!(option)){
            System.out.println("turning off TV");
            television.tvPowerButton(false);
        }
    }
}
