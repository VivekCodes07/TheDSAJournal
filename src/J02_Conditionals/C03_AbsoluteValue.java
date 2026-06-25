package J02_Conditionals;
import java.util.Scanner;

public class C03_AbsoluteValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to get Absolute value: ");
        int number = sc.nextInt();

        if (number >= 0) {
            System.out.print("Absolute value = " + number);
        } else {
            System.out.print("Absolute value = " + (-number));
        }

        sc.close();
    }
}
