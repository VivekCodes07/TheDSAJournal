package J04_Loops;

import java.util.Scanner;

public class C14_SumOfDigits {
    public static void main(String[] args) {

        // Step 1: Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Step 2: Take the number as input
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Step 3: Initialize sum variable
        int sum = 0;

        // Step 4: Repeat until all digits are processed
        while (number != 0) {

            // Step 5: Extract the last digit
            int digit = number % 10;

            // Step 6: Add the digit to the sum
            sum += digit;

            // Step 7: Remove the last digit
            number /= 10;
        }

        // Step 8: Display the sum of digits
        System.out.println("Sum of digits = " + sum);

        // Step 9: Close the Scanner
        sc.close();
    }
}