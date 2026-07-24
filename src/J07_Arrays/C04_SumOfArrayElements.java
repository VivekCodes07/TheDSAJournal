package J07_Arrays;

import java.util.Scanner;

public class C04_SumOfArrayElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking the size of the array from the user.
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        // Creating an array of the given size.
        int[] arr = new int[size];

        // Taking input for all the array elements.
        System.out.println("\nEnter " + size + " elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        // Calculating the sum of all the elements in the array.
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Displaying the final sum.
        System.out.println("\nSum of all elements in the array = " + sum);

        sc.close();
    }
}
/*
 * Things I learned:
    - Just loop through the array once and keep adding every element.
    - Don't overthink it, a single variable is enough to store the sum.
    - Always use arr.length in the loop instead of hardcoding the size.

    * Time Complexity  : O(n)
    * Space Complexity : O(1)
 */
