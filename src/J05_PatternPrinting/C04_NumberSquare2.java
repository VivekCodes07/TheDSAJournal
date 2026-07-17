package J05_PatternPrinting;

import java.util.Scanner;

public class C04_NumberSquare2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Number Square: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop controls the rows
    and the inner loop controls the columns.
    Instead of printing the column number, I printed the row number (i).
    Since the value of i remains the same throughout a row,
    the same number gets printed in every column of that row,
    forming a number square pattern.
*/