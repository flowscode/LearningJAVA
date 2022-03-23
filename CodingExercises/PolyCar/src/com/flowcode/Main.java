package com.flowcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("No Name",0,0,0);
        Merc merc = new Merc("Josh", 4, 5, 5);
        BMW bmw = new BMW("Bree", 4, 2, 2);
        Audi audi = new Audi("Shan", 3, 3, 4);
        WeirdCar weirdCar = new WeirdCar("weird",1,1,1);

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(merc);
        cars.add(bmw);
        cars.add(audi);
        cars.add(car);
        cars.add(weirdCar);

        for (Car object : cars) {
            object.startEngine();
            object.accelerate();
            object.pressBreak();
            System.out.println("-----------------------");
        }

    }

}
