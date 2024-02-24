package com.dc.searchs;

import java.util.Arrays;

public class DBubbleSort {

    // bubble sort = pairs of adjacent elements are compared and the elements swapped if they are not in order
    // runtime complexity: Quadratic time O(n^2) (nor a good option for large data set)

    public static void main(String[] args) {

        int[] array = {8,2,4,6,9,3,7,1,5,0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {

        for (int i=0; i < array.length -1; i++){
            for (int j = 0; j < array.length -1 -i; j++) {
                if(array[j] > array [j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
