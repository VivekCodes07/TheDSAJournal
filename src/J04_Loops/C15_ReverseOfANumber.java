package J04_Loops;

import java.util.Scanner;

public class C15_ReverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int reverse = 0;

        while (number != 0) {
            int digit = number % 10;          // get last digit
            reverse = reverse * 10 + digit;  // build reversed number
            number = number / 10;            // remove last digit
        }

        System.out.print("Reverse = " + reverse);
    }
}

/*
 --------------Quick Flow----------

 For input 123
    . digit = 3 -> reverse = 3
    . digit = 2 -> reverse = (3 * 10) + 2
    . digit = 1 -> reverse = (32 * 10) + 1

*/