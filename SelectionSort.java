//Write a program to Sort the given array using Selection sort.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelctionSort {
    public static int[] selectionSort(int[] unSortedArr){
        int min_index=0,temp = 0;
        for (int i = 0; i < unSortedArr.length; i++) {
            min_index = i;
            for (int j = i+1; j < unSortedArr.length; j++) {
                if(unSortedArr[min_index]>unSortedArr[j]){
                    min_index = j;
                }
            }
            temp = unSortedArr[i];
            unSortedArr[i] = unSortedArr[min_index];
            unSortedArr[min_index] = temp;
        }
        return unSortedArr;
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
        System.out.println("Unsorted Array -> "+Arrays.toString(arr));
        System.out.println("Sorted Array -> "+Arrays.toString(selectionSort(arr)));
    }
}
