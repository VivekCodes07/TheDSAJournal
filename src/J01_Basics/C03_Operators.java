package J01_Basics;

/*
 ──────────────────────────────────────────────
                 JAVA OPERATORS
 ──────────────────────────────────────────────

 Operators are symbols that perform operations
 on variables and values.

 Categories Covered:
 • Arithmetic Operators
 • Assignment Operators
 • Comparison Operators
 • Logical Operators
 • Unary Operators
 • Ternary Operator
*/

public class C03_Operators {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        /*
         ──────────────────────────
         Arithmetic Operators
         ──────────────────────────
         +  Addition
         -  Subtraction
         *  Multiplication
         /  Division
         %  Modulus (Remainder)
        */
        System.out.println("=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));


        /*
         ──────────────────────────
         Assignment Operators
         ──────────────────────────
         =   Assign
         +=  Add and assign
         -=  Subtract and assign
         *=  Multiply and assign
         /=  Divide and assign
         %=  Modulus and assign
        */
        System.out.println("\n=== Assignment Operators ===");

        int x = 10;

        x += 5;
        System.out.println("x += 5  → " + x);

        x -= 3;
        System.out.println("x -= 3  → " + x);

        x *= 2;
        System.out.println("x *= 2  → " + x);

        x /= 4;
        System.out.println("x /= 4  → " + x);

        x %= 3;
        System.out.println("x %= 3  → " + x);


        /*
         ──────────────────────────
         Comparison Operators
         ──────────────────────────
         ==  Equal to
         !=  Not equal to
         >   Greater than
         <   Less than
         >=  Greater than or equal
         <=  Less than or equal
        */
        System.out.println("\n=== Comparison Operators ===");

        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));


        /*
         ──────────────────────────
         Logical Operators
         ──────────────────────────
         &&  AND
         ||  OR
         !   NOT
        */
        System.out.println("\n=== Logical Operators ===");

        boolean isJavaFun = true;
        boolean completedPractice = false;

        System.out.println(
                "AND (&&) : "
                        + (isJavaFun && completedPractice)
        );

        System.out.println(
                "OR (||) : "
                        + (isJavaFun || completedPractice)
        );

        System.out.println(
                "NOT (!) : "
                        + (!isJavaFun)
        );


        /*
         ──────────────────────────
         Unary Operators
         ──────────────────────────
         ++  Increment
         --  Decrement
        */
        System.out.println("\n=== Unary Operators ===");

        int count = 5;

        System.out.println("Initial Value : " + count);

        count++;
        System.out.println("After count++ : " + count);

        count--;
        System.out.println("After count-- : " + count);


        /*
         ──────────────────────────
         Ternary Operator
         ──────────────────────────

         Syntax:
         condition ? value1 : value2;
        */
        System.out.println("\n=== Ternary Operator ===");

        int marks = 85;

        String result =
                (marks >= 40)
                        ? "Pass"
                        : "Fail";

        System.out.println("Result : " + result);
    }
}