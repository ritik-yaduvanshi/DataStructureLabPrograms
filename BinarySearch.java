//Write a program to search an element with in array using binary search
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static boolean binarySearch(int[] sortedArr,int item){
        int lower_Index = 0;
        int higher_Index = sortedArr.length-1;
        int middle_Index = (lower_Index+higher_Index)/2;
        boolean res = false;
        while (lower_Index<=higher_Index){
            if(sortedArr[middle_Index] == item){
                res = true;
                break;
            }
            else if(sortedArr[middle_Index] < item){
                lower_Index = middle_Index + 1;
            }
            else{
                higher_Index = middle_Index - 1;
            }
            middle_Index = (lower_Index + higher_Index)/2;
        }
        if(lower_Index > higher_Index){
            res = false;
        }
        return res;
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
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the Element You Want to Search :");
        int element = scan.nextInt();
        Arrays.sort(arr);
        boolean res = binarySearch(arr,element);
        if(res){
            System.out.println("Element Found!");
        }else{
            System.out.println("Element Not Found!");
        }

    }
}
