package com.dc.searchs;

public class GRecursion {

    // Recursion: Apply the result of a procedure to a procedure
    // commonly used with advanced sorting algorithms and navigating trees
    // Advantages: easier to read/write and debug
    // Disadvantages: sometimes slower and uses more memory (Call stack)

    public static void main(String[] args) {
        walk(5);
        System.out.println(factorial(3));
        System.out.println(power(3,2));
    }

    private static int power(int base, int exponent) {
        if(exponent<1) return 1;
        return base * power(base, exponent-1);
    }

    private static int factorial(int number) {
        if (number<1) return 1;
        return number * factorial(number-1);
    }

    private static void walk(int steps) {
        if (steps < 1) return;
        System.out.println("You take a step");
        walk(--steps);
    }
}
