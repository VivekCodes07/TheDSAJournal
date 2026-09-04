package J07_Arrays;

import java.util.Scanner;

public class C14_MinimumElementOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.printf("\nEnter %d elements for array \n", size);
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("Enter element for index %d: ", i);
            arr[i] = sc.nextInt();
        }

        // Finding Minimum element
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.printf("\nMinimum element = %d", min);

    }
}
