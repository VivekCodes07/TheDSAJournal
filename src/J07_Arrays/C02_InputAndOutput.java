package J07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class C02_InputAndOutput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        // Creating an array of the given size
        int[] arr = new int[size];

        // Taking input for each element
        System.out.println("\nEnter " + size + " elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        // Printing the array using Arrays.toString()
        System.out.println("\nArray using Arrays.toString():");
        System.out.println(Arrays.toString(arr));

        // Printing the array using a for loop
        System.out.println("\nArray using for loop:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        sc.close();
    }
}
/*
 * Things I learned:
     - The size of an array can be decided at runtime.
     - Arrays are created using the 'new' keyword.
     - We use a loop to take input for every element.
     - Arrays.toString() prints the whole array in a readable format.
     - A for loop can also be used to print array elements manually.
 */