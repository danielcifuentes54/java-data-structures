package com.dc.exercises;

import java.util.Arrays;

public class MinimumSteps {

    /**
     Problem statement
     You are given an array ‘ARR’ consisting of ‘N’ integers. Your task is to make all the numbers equal. You decrease one of the largest numbers present in the array into a number that is just lower than the maximum number in one step.

     For example:
     You are given ‘ARR’ = [5, 2, 3]
     In the first step, you can change 5 to 3, so the new array is [3, 2,3].

     In the second step, you can change the 3 to 2, then the array is [2, 2,3].

     In the third step, you can change the 3 to 2, then the array is [2, 2, 2]

     Hence the answer is 3.
     */
    public static void main(String[] args) {
        int[] arr = {4, 2, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(minimumSteps(3, arr));
    }

    public static int minimumSteps(int n, int[] arr) {

        int steps = 0;
        Arrays.sort(arr);

        for (int i = arr.length-1; i >=0; i--) {
            for (int j = i-1; j >=0; j--) {
                if(arr[i] > arr[j]){
                    arr[i] = arr[j];
                    steps++;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }

        return steps;
    }
}
