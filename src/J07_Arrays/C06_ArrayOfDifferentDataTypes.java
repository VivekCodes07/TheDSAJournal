package J07_Arrays;

import java.util.Arrays;

public class C06_ArrayOfDifferentDataTypes {

    public static void main(String[] args) {

        // Integer Array
        int[] numbers = {10, 20, 30, 40, 50};

        // Double Array
        double[] prices = {99.99, 149.50, 250.75};

        // Float Array
        float[] marks = {85.5f, 90.0f, 76.25f};

        // Long Array
        long[] population = {1450000000L, 340000000L, 68000000L};

        // Short Array
        short[] temperatures = {25, 30, 35};

        // Byte Array
        byte[] data = {10, 20, 30, 40};

        // Character Array
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        // Boolean Array
        boolean[] results = {true, false, true, true};

        // String Array
        String[] names = {"Vivek", "Rahul", "Aman", "Priya"};

        System.out.println("Integer Array   : " + Arrays.toString(numbers));
        System.out.println("Double Array    : " + Arrays.toString(prices));
        System.out.println("Float Array     : " + Arrays.toString(marks));
        System.out.println("Long Array      : " + Arrays.toString(population));
        System.out.println("Short Array     : " + Arrays.toString(temperatures));
        System.out.println("Byte Array      : " + Arrays.toString(data));
        System.out.println("Character Array : " + Arrays.toString(vowels));
        System.out.println("Boolean Array   : " + Arrays.toString(results));
        System.out.println("String Array    : " + Arrays.toString(names));
    }
}

/*
 * Things I learned:
 * - Arrays can store any data type, but all elements must be of the same type.
 * - Arrays.toString() is the easiest way to print a 1D array.
 * - float values need an 'f' suffix and long values need an 'L' suffix.
 * - String is a reference type, while int, char, boolean, etc. are primitive types.
 *
 * Time Complexity  : O(1)
 * Space Complexity : O(1)
 */