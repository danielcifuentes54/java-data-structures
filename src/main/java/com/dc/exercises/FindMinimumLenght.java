package com.dc.exercises;

import java.util.Arrays;

public class FindMinimumLenght {

    /**
     * You have given an array ‘ARR’ of integers. Find the minimum length of a subarray such that choosing this subarray will make the whole array sorted in ascending order.
     *
     * Example :
     *
     * Given ‘ARR’ : {1, 3, 2, 4, 5}
     * Selecting subarray {3, 2} and sorting it will make the whole array sorted.
     * Resultant ‘ARR’ : {1, 2, 3, 4, 5}
     *
     * So, the minimum length will be 2.
     */
    public static void main(String[] args) {

        //int[] array = {1, 3, 2, 4, 5}; //result must to be  2
        int[] array = {2, 6, 5, 1, 9, 10}; //result must to be 4
        //int[] array = {2, 3, 4, 1, 9, 10}; //result must to be 4
        System.out.println(minimumDifferenceBetterPerformace(array, array.length));

    }
    public static int minimumDifference(int[] arr, int n) {

        // Copy of array.
        int[] arrCopy = Arrays.copyOf(arr, n);

        // Sorting the array.
        Arrays.sort(arrCopy);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrCopy));

        // Starting and ending point of subarray.
        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (arrCopy[i] != arr[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        if (end > start) {
            return end - start + 1;
        }
        return 0;
    }


    public static int minimumDifferenceBetterPerformace(int[] arr, int n) {
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        System.out.println("left: " + left);
        // If the entire array is already sorted, return 0
        if (left == n - 1) {
            return 0;
        }

        // Find the rightmost index where the array is out of order
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        System.out.println("right: " + right);

        // Find the minimum and maximum elements within the unordered subarray
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);

        // Expand the unordered subarray to include any elements less than min or greater than max
        while (left > 0 && arr[left - 1] > min) {
            left--;
        }

        System.out.println("left: " + left);

        while (right < n - 1 && arr[right + 1] < max) {
            right++;
        }

        System.out.println("right: " + right);

        // Return the length of the unordered subarray
        return right - left + 1;
    }
}
