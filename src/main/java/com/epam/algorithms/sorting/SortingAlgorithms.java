package com.epam.algorithms.sorting;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int arr[] = {6,3,2,1,5,9,7,8,15};
        SortingAlgorithms so = new SortingAlgorithms();
        //so.bubbleSort(arr);
        so.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left>=right)
            return;
        //partitioning
        int pi = partition(arr,left,right);
        //sort left side to pivot
        quickSort(arr,left,pi-1);
        //sort right side to pivot
        quickSort(arr,pi+1,right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot=arr[right];
        int i=left-1;
        for(int j=left;j<right;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,right);
        return i+1;
    }

    private void swap(int[] arr, int left, int right) {
        int swap = arr[left];
        arr[left] = arr[right];
        arr[right] = swap;
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
