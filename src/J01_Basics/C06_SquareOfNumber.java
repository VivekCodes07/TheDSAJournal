package J01_Basics;
import java.util.Scanner;
public class C06_SquareOfNumber {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the number whose square you want: ");
        double number = sc.nextInt();
        System.out.println("Square = " + number * number);
    }
}
