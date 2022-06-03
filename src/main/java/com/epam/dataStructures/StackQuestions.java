package com.epam.dataStructures;

import java.util.Stack;

public class StackQuestions {
    public static void main(String[] args) {
        System.out.println(aliceLibrary("/u/love\\i\\"));
    }

    private static String aliceLibrary(String input) {

        Stack<Character> stack = new Stack<>();
        char curr;
        for(int i=0;i<input.length();i++){
            curr = input.charAt(i);
            if(curr=='/' || (curr>='a' && curr<='z')) {
                stack.push(curr);
            } else {
                StringBuilder sb=new StringBuilder();
                while (stack.peek()!='/'){
                    sb.append(stack.pop());
                }
                stack.pop();

                for(int j=0;j<sb.length();j++){
                    stack.push(sb.charAt(j));
                }
            }
        }
        StringBuilder answer=new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
