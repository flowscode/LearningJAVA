package com.flowcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};

        System.out.println("Numbers = " + Arrays.toString(numbers));
        reverse(numbers);

        System.out.println("Reversed Numbers = " + Arrays.toString(numbers));

    }

    private static void reverse(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex -i];
            array[maxIndex - i] = temp;

        }

    }
}
