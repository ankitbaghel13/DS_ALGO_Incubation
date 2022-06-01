package com.epam.algorithms.sorting;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int arr[] = {4,3,5,1,2};
        SortingAlgorithms so = new SortingAlgorithms();
        so.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity
    //  Best case - 0(n)
    //  Average case - 0(n^2)
    //  Worst case - 0(n^2)
    private void bubbleSort(int[] arr) {
        int length = arr.length;
        int swap=0;
        boolean isSwap=true;
        //{4,3,5,1,2}
        for(int i=0;i<length-1;i++){
            isSwap=false;
            for(int j=0;j<length-1;j++){
                if(arr[j]>arr[j+1]){
                   swap = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = swap;
                   isSwap=true;
                }
            }
            if(!isSwap)
                break;
        }
    }
}
