package J04_Loops;

import java.util.Scanner;

public class C16_PowerOfANumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int a = sc.nextInt();

        System.out.print("Enter the power: ");
        int b = sc.nextInt();

        int result = 1;

        for (int i = 1; i <= b; i++) {
            result = result * a;
        }

        System.out.println("Result: " + result);
    }
}

/*
---------Quick Flow----------

For a = 2, b = 3
    . start → result = 1
    . step 1 → result = 1 × 2 = 2
    . step 2 → result = 2 × 2 = 4
    . step 3 → result = 4 × 2 = 8

→ final = 8

*/

