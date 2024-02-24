package com.dc.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 *
 * Example 2:
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 */
public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder happyString = new StringBuilder();
        int total = a+b+c;
        int aOccurrences = 0, bOccurrences = 0 , cOccurrences = 0;

        for (int i = 0; i < total; i++) {
            if((a >= b && a >= c && aOccurrences < 2) ||(bOccurrences == 2 && a > 0) || (cOccurrences == 2 && a > 0) ){
                happyString.append("a");
                a--;
                aOccurrences ++;
                bOccurrences=0;
                cOccurrences=0;
            }else if ((b >= a && b>=c && bOccurrences <2) || (aOccurrences == 2 && b > 0) || (cOccurrences == 2 && b > 0) ){
                happyString.append("b");
                b--;
                bOccurrences ++;
                aOccurrences=0;
                cOccurrences=0;
            } else if( (c >= a && c >= b && cOccurrences <2) || (bOccurrences == 2 && c > 0) || (aOccurrences == 2 && c > 0)){
                happyString.append("c");
                c--;
                cOccurrences ++;
                aOccurrences=0;
                bOccurrences=0;
            }
        }

        return happyString.toString();
    }

    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1,2,7));
    }
}
