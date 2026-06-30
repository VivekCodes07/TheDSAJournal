package J03_Conditionals;

import java.util.Scanner;

public class C02_DivisibilityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to check if it is divisible by 5 or not: ");
        int number = sc.nextInt();

        if (number % 5 == 0) {
            System.out.println("Yes, it is divisible.");
        } else {
            System.out.println("No, it's not divisible.");
        }

    }
}
