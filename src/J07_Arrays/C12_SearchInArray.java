package J07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class C12_SearchInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {55, 66, 98, 56, 98};
        System.out.println("The array elements are: " + Arrays.toString(arr));

        System.out.print("Enter the element you want to find: ");
        int x = sc.nextInt();

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                // Fixed: Changed the comma to a '+'
                System.out.println("Element found at index: " + i);
                break;
            }
        }
    }
}
