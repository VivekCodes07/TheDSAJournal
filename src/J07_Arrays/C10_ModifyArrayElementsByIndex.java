package J07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class C10_ModifyArrayElementsByIndex {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element for index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        // Ques: Multiply odd indexed elements by 2
        // and add 10 to even indexed elements

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] = arr[i] * 2;
            } else {
                arr[i] = arr[i] + 10;
            }
        }

        System.out.println("The required array is: " + Arrays.toString(arr));

        sc.close();
    }
}

/*
Original:  10  20  30  40  50

Index:      0   1   2   3   4

Operation: +10 ×2  +10 ×2  +10

Result:    20  40  40  80  60
*/