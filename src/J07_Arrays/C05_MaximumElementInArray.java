package J07_Arrays;

import java.util.Scanner;

public class C05_MaximumElementInArray {

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

        // Assuming the first element is the maximum.
        int max = arr[0];

        // Comparing the remaining elements with the current maximum.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Displaying the maximum element.
        System.out.println("\nMaximum element in the array = " + max);

        sc.close();
    }
}

/*
 * Things I did here:
   - Initializing max with 0 can give the wrong answer if all elements are negative.
   - It's safer to assume the first element is the maximum.
   - After that, I just compare the remaining elements and update max whenever I find a larger value.

   * Time Complexity  : O(n)
   * Space Complexity : O(1)
 */