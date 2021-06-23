/*
Write a program to print all the duplicate elements present in the given array.
for example 1,8,1,9,2,3,8,6,9,1
output 1,8,9 */

import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateArray {
    static void duplicates(int[] arr,int size){
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            count = 0;
            for (int i1 = 0; i1 < size; i1++) {
                if(arr[i]==arr[i1]){
                    count++;
                }
            }
            if(count>1){
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                }
            }
        }
        list.forEach((value) -> System.out.print(value+" "));
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        duplicates(arr,size);
    }
}

