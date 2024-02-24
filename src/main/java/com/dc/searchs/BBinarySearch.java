package com.dc.searchs;

import java.util.Arrays;

public class BBinarySearch {

    // Binary search - Search algorithm that finds the position of a target value  within a sorted array.
    // Half of the array is eliminated during each "step"
    // runtime complexity: 0(log n)
    // Need to sorted

    public static void main(String[] args) {

        int[] array = {1,2,4,8,16,32,64,128,256,1024,2048};
        int target = 1024;

        /*
        // // This dataset is better with InterpolationSearch
        int[] array = new int[100000000];
        int target = 4657893;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }*/

        //int index = Arrays.binarySearch(array, target);
        int index = binarySearch(array, target);

        if(index >= 0){
            System.out.println("Target: " + target + " Found at index: " + index);
        }else{
            System.out.println("Target: " + target + " not found");
        }
    }

    private static int binarySearch(int[] array, int target) {

        int lowIndex = 0;
        int highIndex = array.length -1;
        int iterations = 0; // just to know how many steps do the algorithm

        while (lowIndex <= highIndex){

            iterations ++;

            //int middleIndex = (lowIndex + highIndex) / 2; //could lead to overflow
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            int value = array[middleIndex];

            if(value < target) {
                lowIndex = middleIndex + 1;
            }
            else if (value > target) {
                highIndex = middleIndex -1;
            }
            else {
                System.out.println("iterations: " + iterations);
                return middleIndex;
            }
        }

        System.out.println("iterations: " + iterations);
        return -1;
    }
}
