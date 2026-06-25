package J02_Conditionals;

import java.util.Scanner;

public class C01_EvenOddCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check if it is Even or Odd: ");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.print("Type: Even");
        } else {
            System.out.print("Type: Odd");
        }
    }
}
