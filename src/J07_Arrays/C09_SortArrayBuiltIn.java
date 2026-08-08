package J07_Arrays;
import java.util.Arrays;
public class C09_SortArrayBuiltIn {
    public static void main(String args[]) {
        int[] arr = {4, 1, 7, 5, -3, 10, 2};
        print(arr);

        Arrays.sort(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

/*
    I created an integer array and used a separate print() method
    to print the array before and after sorting.
    I used Arrays.sort(arr) to sort the array in ascending order.
    Since arrays are mutable, Arrays.sort() directly changes the
    original array instead of creating a new one.
    After sorting, I called print() again to see the sorted array.
*/