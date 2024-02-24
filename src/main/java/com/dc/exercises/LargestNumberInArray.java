package com.dc.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestNumberInArray {

    /*
        Given an array ‘A’ consisting of ‘N’ integers, you should return the biggest value ‘X’, which occurs in ‘A’ exactly ‘X’ times. If there is no such value, you should return 0.

        For example:

        In the given array A[] = {1, 2, 2, 3, 3, 3,}  1 has occurred 1 times, 2 has occurred 2 times and 3 has occurred 3 times. So we will return 3 since it is the maximum number.

     */

    public static void main(String[] args) {
        int[] a = {4,4,1, 2,4,4, 2, 3, 3, 3};
        System.out.println(findX(a));
    }


    public static int findX(int[] arr) {
        Map<Integer, Integer> numberOccurs = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            numberOccurs.put(arr[i], numberOccurs.getOrDefault(arr[i], 0)+1);
        }

        Arrays.sort(arr);

        for(int i=arr.length-1; i>=0; i--){
            if(numberOccurs.get(arr[i]) == arr[i])
                return arr[i];
        }

        return 0;
    }
}
