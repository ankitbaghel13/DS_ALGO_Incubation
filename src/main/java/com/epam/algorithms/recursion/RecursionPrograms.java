package com.epam.algorithms.recursion;

public class RecursionPrograms {
    public static void main(String[] args) {
        //int result = factorial(5);
        //int result = sumOfDigits(12345);
        //String result = printStringInReverseOrder("ankit");
        boolean result = isPalindrome("sabccbas");
        System.out.println(result);
    }

    private static boolean isPalindrome(String input) {
        int length = input.length();
        if(length<=1)
            return true;
        return input.charAt(0)==input.charAt(length-1) && isPalindrome(input.substring(1,length-1));
    }

    private static String printStringInReverseOrder(String input) {
        if(input.length()<=1)
            return input;
        return printStringInReverseOrder(input.substring(1))+input.charAt(0);
    }

    private static int sumOfDigits(int num) {
        if(num==0)
            return num;
        return (num%10)+sumOfDigits(num/10);
    }

    private static int factorial(int num) {
        if(num==1)
            return 1;
        return num*factorial(num-1);
    }
}
