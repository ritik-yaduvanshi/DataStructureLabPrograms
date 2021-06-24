//Write a program to Sort the given array using Insertion sort.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static int[] insertionSort(int[] unsortedArr){
        int temp = 0;
        for (int i = 1; i < unsortedArr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(unsortedArr[j]<unsortedArr[j-1]){
                    temp = unsortedArr[j];
                    unsortedArr[j]=unsortedArr[j-1];
                    unsortedArr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return unsortedArr;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random val = new Random();
        System.out.println("Enter the size of Array : ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = val.nextInt(20);
        }
        System.out.println("Unsorted Array -> "+ Arrays.toString(arr));
        System.out.println("Sorted Array -> "+Arrays.toString(insertionSort(arr)));
    }
}
