package com.flowcode;

public class Main {

    public static void main(String[] args) {
	    int[] numbers = {1,2,3,4,5,6};

        for (int i: numbers) {
            System.out.println(i);
            for (int j = 0; j < numbers.length; j++) {
                System.out.println(numbers[j]);
            }
        }


    }
}
