package com.dc.exercises;

import java.util.Arrays;

public class CoinChange {

    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * The answer is guaranteed to fit into a signed 32-bit integer.
     */

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {

        int[] arr = new int[amount+1];
        arr[0] = 1;
        for (int coin:coins) {
            System.out.println("################");
            for (int i = coin; i <= amount ; i++) {
                arr[i] += arr[i-coin];
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("@@@@@@@@@@@@@@@@");
            System.out.println(Arrays.toString(arr));
            System.out.println("@@@@@@@@@@@@@@@@");
        }

        return arr[amount];


    }
}
