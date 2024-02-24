package com.dc.exercises;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space. ==> MUST to be binary search
 */
public class SingleElementInSortedArray {

    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,3,4,4,5,5,6,8,8};
        System.out.println(singleNonDuplicate(array));
    }

    public static int singleNonDuplicate(int[] nums){
        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            boolean isEven = (right-mid) % 2 == 0;
            if(nums[mid] == nums[mid-1]){
                if(isEven){
                    right = mid -2;
                }else{
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid+1]) {
                if(isEven){
                    left=mid+2;
                }else {
                    right = mid+1;
                }
            }else{
                return nums[mid];
            }
        }

        return nums[left];
    }
}
