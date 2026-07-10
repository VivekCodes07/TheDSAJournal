package J04_Loops;

import java.util.Scanner;

public class C12_DigitsOfANumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        if (number == 0) {
            System.out.println("Number of digits: 1");
            return;
        }

        number = Math.abs(number);

        int count = 0;

        while (number != 0) {
            number /= 10;
            count++;
        }

        System.out.println("Number of digits: " + count);

        sc.close();
    }
}