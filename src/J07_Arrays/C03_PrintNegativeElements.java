package J07_Arrays;

import java.util.Scanner;

public class C03_PrintNegativeElements {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the Array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("\nEnter " + size + " elements: ");

        for(int i = 0; i < arr.length; i++) {
            System.out.print("Element for index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        // Printing out negative elements from array:
        boolean found = false;
        System.out.println("\nPriting negative elements from array: ");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                System.out.print(arr[i] + ", ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No negative elements found.");
        }

        sc.close();
    }
}
/*
 * Things I learned:
   - We can use a loop to check every element in an array.
   - An if statement helps us filter elements based on a condition.
   - Negative numbers are those less than 0.
   - A boolean flag can be used to check if any matching element was found.
 */
