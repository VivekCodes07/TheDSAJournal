package J03_Conditionals;
import java.util.Scanner;
public class C04_CheckInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a real number: ");
        double number = sc.nextDouble();

        if (number % 1 == 0) {
            System.out.println((int)number + " is an integer");
        } else {
            System.out.println(number + " is a decimal number (not an integer)");
        }
    }
}
