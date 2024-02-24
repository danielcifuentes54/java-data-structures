package com.dc.data.structures;

import java.util.Arrays;

public class WorkingWithArray {

    public static void main(String[] args) {
        String[] colors = new String[10];

        colors[0] = "blue";
        colors[1] = "green";

        System.out.println(Arrays.toString(colors));

        int[] numbers = {100,200,300};

        System.out.println("printing with for (asc)");
        for (int i=0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        System.out.println("printing with for (desc)");
        for(int i = numbers.length-1; i >= 0; i--){
            System.out.println(numbers[i]);
        }

        System.out.println("printing with for each (asc)");
        for (int number : numbers){
            System.out.println(number);
        }

        System.out.println("printing with Stream (asc)");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
