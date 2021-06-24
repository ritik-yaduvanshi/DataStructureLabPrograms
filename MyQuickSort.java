
import java.util.Arrays;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] arr = {35,8,24,3,2,10};
        int lower = 0;
        int upper = arr.length - 1;
        System.out.println("unsorted --> " + Arrays.toString(arr));
        MyQuickSort obj = new MyQuickSort();
        obj.quickSort(arr, lower, upper);
        System.out.println("sorted --> " + Arrays.toString(arr));
    }
    public void quickSort(int[] arr, int lower, int upper){
        if(lower >= upper){
            return;
        }
        int pivotIndex = partition(arr, lower, upper);
        quickSort(arr, lower, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1 , upper);
    }

    private int partition(int[] arr, int lower, int upper) {
        //step 1
        int pivot = arr[lower];
        int down = lower;
        int up = upper;
        while(down < up){
            while(down <= upper && arr[down] <= pivot){
                down = down + 1;

            }
            while( up >= lower && arr[up] > pivot){
                up = up - 1;

            }
            if(down < up){
                int temp = arr[down];
                arr[down] = arr[up];
                arr[up] = temp;
            }

        }
        arr[lower] = arr[up];
        arr[up] = pivot;
        return up;
    }
}
