package com.dc.searchs;

import java.util.Arrays;

public class CInterpolationSearch {

    // Interpolation Search: Improvement over binary search best used for "uniformly"!! (1,2,3,4,5...) distributed
    //                       "guesses" where a value might be based on calculated probe results
    //                        if the probe we narrow the search and try again
    // runtime complexity (average): 0(log(log n))
    // runtime complexity (worst case): 0(n)
    // Need to sorted
    
    public static void main(String[] args) {

        /*
        // This dataset is better with binarySearch
        int[] array = {1,2,4,8,16,32,64,128,256,1024,2048};
        int target = 1024;
        */

        int[] array = new int[100000000];
        int target = 4657892;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int index = interpolationSearch(array, target);

        if(index >= 0){
            System.out.println("Target: " + target + " Found at index: " + index);
        }else{
            System.out.println("Target: " + target + " not found");
        }
    }

    private static int interpolationSearch(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;
        int iterations = 0; // just to know how many steps do the algorithm

        while(target >= array[low] && target <= array[high] && low <= high){
            int probe =   low + (( (high - low) / (array[high] - array[low]) ) * (target - array[low]));

            iterations++;
            if(array[probe] == target){
                System.out.println("iterations: " + iterations);
                return probe;
            }else if(array[probe] < target){
                low = probe + 1;
            }else {
                high = probe - 1;
            }
        }

        System.out.println("iterations: " + iterations);
        return -1;
    }
}
