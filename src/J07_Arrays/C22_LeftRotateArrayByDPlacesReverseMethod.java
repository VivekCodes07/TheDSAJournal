package J07_Arrays;

import java.util.Scanner;

public class C22_LeftRotateArrayByDPlacesReverseMethod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.print("Enter how many elements you want to rotate: ");
        int d = sc.nextInt();
        d = d % arr.length;

        sc.close();
    }
}
