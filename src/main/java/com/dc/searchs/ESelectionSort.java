package com.dc.searchs;

import java.util.Arrays;

public class ESelectionSort {

    // Selection sort = Search through an array and keep track of the minimum value during each iteration. At the end of each iteration, we swap variables
    // runtime complexity: Quadratic time O(n^2) (nor a good option for large data set)

    public static void main(String[] args) {
        int[] array = {8,2,4,6,9,3,7,1,5,0};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
    }

    private static void selectionSort(int[] array) {

        for (int i = 0; i < array.length -1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min] > array[j]){
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            System.out.println(Arrays.toString(array));

        }
    }
}