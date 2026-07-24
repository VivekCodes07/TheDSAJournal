package J07_Arrays;

import java.util.Arrays;

public class C01_Basics {

    public static void main(String[] args) {

        // Declaring and initializing an array
        int[] arr = {12, 45, 7, 90, 31};

        // Printing the array reference
        System.out.println("Printing array directly:");
        System.out.println(arr);

        // Printing the array using Arrays.toString()
        System.out.println("\nPrinting array using Arrays.toString():");
        System.out.println(Arrays.toString(arr));

        // Accessing elements using index
        System.out.println("\nAccessing Elements:");
        System.out.println("First Element  : " + arr[0]);
        System.out.println("Third Element  : " + arr[2]);
        System.out.println("Last Element   : " + arr[arr.length - 1]);

        // Updating an element
        arr[2] = 70;
        System.out.println("\nAfter Updating Third Element:");
        System.out.println(Arrays.toString(arr));

        // Finding the length of the array
        System.out.println("\nLength of Array:");
        System.out.println(arr.length);
    }
}
/*
 * Things I learned:
 * - An array stores elements of the same data type.
 * - Array indexing starts from 0.
 * - Printing an array directly prints its reference, not its elements.
 * - Arrays.toString() is the proper way to print a 1D array.
 * - Arrays have a fixed size once they are created.
 */