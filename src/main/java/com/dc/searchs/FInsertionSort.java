package com.dc.searchs;

import java.util.Arrays;

public class FInsertionSort {

    // Insertion sort = After comparing elements to the left shift elements to the right to make room to insert a value
    // runtime complexity: Quadratic time O(n^2) (nor a good option for large data set)
    //                     less steps than bubble sort
    //                     Best case is O(n) compared to selection sort O(n^2)

    public static void main(String[] args) {
        int[] array = {8,2,4,6,9,3,7,1,5,0};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
    }

    private static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
}
