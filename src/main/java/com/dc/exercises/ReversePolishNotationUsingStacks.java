package com.dc.exercises;

import java.util.Stack;

public class ReversePolishNotationUsingStacks {

    public static void main(String[] args) {
        //String[] tokens = {"2","1","+","3","*"}; //result must be 9
        //String[] tokens = {"4","13","5","/","+"}; //result must be 6
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; //result must be 22
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();

        for(String token : tokens){
            System.out.println(result);
            if (token.equals("+")){
                result.add(result.pop()+result.pop());
            } else if (token.equals("*")){
                result.add(result.pop()*result.pop());
            } else if (token.equals("-")){
                int a = result.pop();
                int b = result.pop();
                result.add(b-a);
            } else if (token.equals("/")){
                int a = result.pop();
                int b = result.pop();
                result.add(b/a);
            }else{
                result.add(Integer.parseInt(token));
            }
        }
        return result.pop();
    }
}
