package com.dc.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        //String[] tokens = {"2","1","+","3","*"}; //result must be 9
        //String[] tokens = {"4","13","5","/","+"}; //result must be 6
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; //result must be 22
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        List<String> tokensList = new ArrayList<>(Arrays.asList(tokens));

        while(tokensList.size()>1){
            for (int i = 2; i < tokensList.size(); i++) {
                if (tokensList.get(i).equals("+")) {
                    int result = Integer.parseInt(tokensList.get(i - 2)) + Integer.parseInt(tokensList.get(i - 1));
                    System.out.println("result: " + result);
                    recreateList(tokensList, i, result);
                    break;
                }
                if (tokensList.get(i).equals("-")) {
                    int result = Integer.parseInt(tokensList.get(i - 2)) - Integer.parseInt(tokensList.get(i - 1));
                    recreateList(tokensList, i, result);
                    break;
                }
                if (tokensList.get(i).equals("*")) {
                    System.out.println("por");
                    int result = Integer.parseInt(tokensList.get(i - 2)) * Integer.parseInt(tokensList.get(i - 1));
                    recreateList(tokensList, i, result);
                    break;
                }
                if (tokensList.get(i).equals("/")) {
                    int result = Integer.parseInt(tokensList.get(i - 2)) / Integer.parseInt(tokensList.get(i - 1));
                    recreateList(tokensList, i, result);
                    break;
                }
            }

        }

        return Integer.parseInt(tokensList.get(0));
    }

    public static List<String> recreateList(List<String> tokensList, int i, int result){

        IntStream.range(0,3).forEach(index -> tokensList.remove(i-2));
        tokensList.add(i-2, String.valueOf(result));
        return tokensList;
    }


}
