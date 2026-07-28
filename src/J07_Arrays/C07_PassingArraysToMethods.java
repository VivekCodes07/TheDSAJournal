package J07_Arrays;

import java.util.Arrays;

public class C07_PassingArraysToMethods {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Passing the array to print all its elements.
        printArray(arr);

        // Passing the same array to double every element.
        doubleArrayElements(arr);

        // Printing the modified array.
        printArray(arr);
    }

    // Printing all the elements of the array.
    public static void printArray(int[] array) {

        System.out.print("Printing elements of the array: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    // Doubling every element of the array.
    public static void doubleArrayElements(int[] array) {

        System.out.println("\nDoubling every element of the array...");

        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }
}

/*
 * Things I learned:
 * - Passing an array to a method doesn't create a new array.
 * - Both the main method and the called method use the same array.
 * - If I change an element inside the method, the original array changes too.
 * - This happens because arrays are reference types in Java.
 *
 * Time Complexity:
 * - printArray()          : O(n)
 * - doubleArrayElements() : O(n)
 *
 * Space Complexity : O(1)
 */