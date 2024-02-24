package com.dc.searchs;

import java.util.Arrays;

public class IQuickSort {

    // Quick sort = Moves smaller elements to left of a pivot, recursive divide array in 2 partitions
    // runtime complexity: Best case  O(n log(n))  Average case  O(n log(n)) worst case O(n^2)
    // space complexity: O(log(n)) due to recursion

    public static void main(String[] args) {
        int[] array = {8,2,4,6,9,3,7,1,5,0};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {

        if(endIndex <= startIndex) return;

        int pivot = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivot-1);
        quickSort(array, pivot + 1, endIndex);

    }

    private static int partition(int[] array, int startIndex, int endIndex) {

        int pivot = array[endIndex];
        int i = startIndex -1;
        for (int j = startIndex; j <= endIndex-1 ; j++) {
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[endIndex];
        array[endIndex] = temp;
        return i;

    }


}
