package J07_Arrays;

public class C17_PrintingSecondMaxElement {
    public static void main(String[] args) {

        int[] arr = {10, 30, 40, 20, 70, 60, 90, 80};

        int max = Integer.MIN_VALUE;
        // Initialize secondMax to the lowest possible value to handle edge cases
        int secondMax = Integer.MIN_VALUE;

        // Loop 1: Find the absolute maximum element first
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        // Loop 2: Now that 'max' is final, find the second maximum element
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] > secondMax && arr[j] < max) {
                secondMax = arr[j];
            }
        }

        System.out.println("Maximum Element: " + max);
        System.out.println("Second Maximum Element: " + secondMax);
    }
}

/*
    Logic I applied:

    First, I find the maximum element of the array and store it in max.

    I start max with Integer.MIN_VALUE so that the first array element
    will definitely be greater than it and can become the maximum.

    After finding max, I run another loop to find the second maximum.

    For every element, I check two conditions:

    1. arr[j] > secondMax
       This means the current element should be greater than the
       second maximum I have found so far.

    2. arr[j] < max
       This makes sure that I don't select the maximum element again.

    If both conditions are true, I update secondMax.

    In the end, secondMax contains the largest element which is
    smaller than max, so it is the second maximum element.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/