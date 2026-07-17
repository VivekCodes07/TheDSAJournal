package J05_PatternPrinting;
import java.util.Scanner;
public class C03_AlphabetSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Alphabet Square: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print((char)(j + 64) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

/*
    Logic:
    - The outer loop is responsible for printing each row.
    - The inner loop prints the alphabets from A up to the given size.
    - I used (char)(j + 64) to convert numbers into uppercase letters
      because the ASCII value of 'A' starts from 65.
    - Since the inner loop always starts from 1 for every row,
      the same sequence of alphabets gets printed on each line,
      creating an alphabet square pattern.
*/