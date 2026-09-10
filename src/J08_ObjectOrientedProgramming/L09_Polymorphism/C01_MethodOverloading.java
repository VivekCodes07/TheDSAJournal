package J08_ObjectOrientedProgramming.L09_Polymorphism;

class Calculator {

    // Same method name, different parameters.
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class C01_MethodOverloading {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        // Compiler selects add(int, int).
        System.out.println(calculator.add(10, 20));

        // Compiler selects add(int, int, int).
        System.out.println(calculator.add(10, 20, 30));

        // Compiler selects add(double, double).
        System.out.println(calculator.add(10.5, 20.5));

        /*
        METHOD OVERLOADING

        I use the same method name:

            add()

        but provide different parameter lists.

        The compiler looks at the arguments and
        decides which method should be called.

        Example:

            add(10, 20)
                ↓
            add(int, int)

        This decision happens at compile time.

        So:

            Method Overloading
                    ↓
            Compile-Time Polymorphism
        */
    }
}