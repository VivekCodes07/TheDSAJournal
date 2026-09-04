package J07_Arrays;

import java.util.Scanner;

public class C13_ProductOfArray {
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

        int product = 1;

        for(int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }

        System.out.printf("\nProduct of all array elements = %d", product);

        sc.close();
    }
}
