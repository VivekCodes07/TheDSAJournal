import java.util.Scanner;

public class C06_StarTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height of the Star Triangle: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop controls the number of rows
    and the inner loop prints the stars in each row.
    For every new row, the value of i increases by 1,
    so the inner loop prints one more star than the previous row.
    This creates a right-angled star triangle pattern.
*/