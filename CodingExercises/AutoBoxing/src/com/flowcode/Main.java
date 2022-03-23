package com.flowcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String>  stringArrayList = new ArrayList<String>();
        stringArrayList.add("Josh");
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            integerArrayList.add(Integer.valueOf(i));
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " --> " + integerArrayList.get(i).intValue());
        }

        int intNumber = 56;
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl+= 0.5) {
            myDoubleValues.add(Double.valueOf(dbl));
        }

        for (int k = 0; k < myDoubleValues.size(); k++) {
            double value = myDoubleValues.get(k).doubleValue();
            System.out.println(k + " --> " + value);
        }
    }
}
