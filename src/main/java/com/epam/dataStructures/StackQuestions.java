package com.epam.dataStructures;

import java.util.Stack;

public class StackQuestions {

    static class Newpair {
        int first,second;
        public Newpair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        //System.out.println(aliceLibrary("/u/love\\i\\"));
        //printNextGreaterElement(new int[]{11,5,21,3});
        System.out.println(countFantabulousPairs(new int[]{1,3,2,4}));
    }

    private static int countFantabulousPairs(int[] arr) {

        int length = arr.length;
        int nextBigArr[] = new int[1000];
        int prevBigArr[] = new int[1000];
        int maxArr[] = new int[1000];
        int answer=0;

        findPreviousLargestElement(arr,length,prevBigArr);
        findNextLargestElement(arr,length,nextBigArr);

        for(int i=0;i<length;i++){
            if(nextBigArr[i]!=i)
                maxArr[nextBigArr[i]-i] = Math.max(maxArr[nextBigArr[i]-1], i-prevBigArr[i]);

        for (int j=0;j<length;j++)
            answer += maxArr[i];
        }
        return answer;
    }

    private static void findNextLargestElement(int[] arr, int length, int[] nextBigArr) {
        Stack<Newpair> stack = new Stack<>();

        for (int i=length-1;i>=0;i--){
            nextBigArr[i] = i;
            while (!stack.isEmpty() && stack.peek().first<arr[i])
                stack.pop();
            if (!stack.isEmpty())
                nextBigArr[i] = stack.peek().second;

            stack.push(new Newpair(arr[i],i));
        }
    }

    private static void findPreviousLargestElement(int[] arr, int length, int[] prevBigArr) {
        Stack<Newpair> stack = new Stack<>();
        for (int i = 0; i < length; i++)
        {

            prevBigArr[i] = -1;
            while (!stack.empty() && stack.peek().first < arr[i])
                stack.pop();

            if (!stack.empty())
                prevBigArr[i] = stack.peek().second;

            stack.push(new Newpair(arr[i], i));
        }
    }

    private static void printNextGreaterElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int element,next;
        // {11,5,21,3}
        for(int i=1;i<nums.length;i++){

            next = nums[i];
            if(!stack.isEmpty()){
                element= stack.pop();
                while (next>element){
                    System.out.println(element+"->"+next);
                    if (stack.isEmpty())
                        break;
                    element=stack.pop();
                }
                if(element>next)
                    stack.push(element);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()){
            element=stack.pop();
            next=-1;
            System.out.println(element+"->"+next);
        }
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