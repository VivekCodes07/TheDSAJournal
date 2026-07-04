package J04_Loops;

import java.util.Scanner;

public class C08_CompositeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check if it's Composite: ");
        int number = sc.nextInt();
        sc.close();

        // 1, 0, and negative numbers are not composite
        if (number <= 1) {
            System.out.println("No, it is not a composite number.");
            return;
        }

        boolean isComposite = false;

        // Simple loop: Checks every single number from 2 up to (number - 1)
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isComposite = true; // Found a factor!
                break;              // Stop looking and exit the loop
            }
        }

        if (isComposite) {
            System.out.println("Yes, it is a composite number.");
        } else {
            System.out.println("No, it is not a composite number.");
        }
    }
}
