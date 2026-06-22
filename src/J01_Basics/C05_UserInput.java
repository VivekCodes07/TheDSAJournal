package J01_Basics;

import java.util.Scanner;

public class C05_UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter radius (in cm): ");
        double radius = sc.nextInt();
        double area = 3.14159 * radius * radius;
        System.out.println("Area of Circle = " + area + " cm sq.");

    }
}
