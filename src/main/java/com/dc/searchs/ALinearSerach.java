package com.dc.searchs;

public class ALinearSerach {

    //linear search - iterate through a collection one element at a time
    // runtime complexity: 0(n)
    // Does not need to sorted

    public static void main(String[] args) {

        int[] array = {6,8,3,9,12,6,8};

        int index = linearSearch(array, 9);

        if (index != -1){
            System.out.println("Value found at index: " + index);
        }else {
            System.out.println("Value not found");
        }
    }

    private static int linearSearch(int[] array, int numberToSearch) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberToSearch)
                return i;
        }

        return -1;
    }
}
