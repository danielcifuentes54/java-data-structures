package com.dc.exercises;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromic {

    public String longestPalindromeBetterPerformance(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }
    public String longestPalindrome(String s) {

        String[] words = s.split("");
        String sol = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length+1; j++) {
                String temp = s.substring(i,j);
                if(isPalindrome(temp) && temp.length() > sol.length()){
                    sol = temp;
                }
            }
        }
        return sol;
    }

    public boolean isPalindrome(String s) {
        String[] sArray = s.split("");
        for (int i = 0; i < sArray.length/2; i++) {
            if(!sArray[i].equals(sArray[sArray.length-1-i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromic longestPalindromic = new LongestPalindromic();
        System.out.println(longestPalindromic.longestPalindromeBetterPerformance("babad"));
        System.out.println(longestPalindromic.longestPalindromeBetterPerformance("cbbd"));
    }

}
