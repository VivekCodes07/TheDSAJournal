package J02_Conditionals;
import java.util.Scanner;

public class C12_TernaryOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your exam score (0-100): ");
        int score = sc.nextInt();

        // --- 1. THE TRADITIONAL IF-ELSE WAY ---
        String resultIfElse;
        if (score >= 50) {
            resultIfElse = "Pass";
        } else {
            resultIfElse = "Fail";
        }
        System.out.println("Result using If-Else: " + resultIfElse);


        // --- 2. THE TERNARY OPERATOR WAY (Short-hand) ---
        // Syntax: variable = (condition) ? value_if_true : value_if_false;
        // Think of '?' as asking "Is this true?" and ':' as "Otherwise".

        String resultTernary = (score >= 50) ? "Pass" : "Fail";
        System.out.println("Result using Ternary: " + resultTernary);


        // --- 3. DIRECT PRINTING EXAMPLE ---
        // You don't even have to store it in a variable!
        System.out.println("Status: " + ((score >= 90) ? "Excellent!" : "Keep learning!"));

        sc.close();
    }
}
