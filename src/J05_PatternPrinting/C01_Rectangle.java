package J05_PatternPrinting;

import java.util.Scanner;

public class C01_Rectangle {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        // Outer loop controls the rows
        for (int i = 1; i <= rows; i++) {

            // Inner loop prints the columns for each row
            for (int j = 1; j <= columns; j++) {
                System.out.print("* ");
            }

            // Move to the next line after printing one complete row
            System.out.println();
        }

        sc.close();
    }
}