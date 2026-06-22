package J01_Basics;

public class C07_Typecasting {

    public static void main(String[] args) {

        // Type Casting in Java 🚀
        // Converting one data type into another

        System.out.println("=== TYPE CASTING DEMO ===");

        // 1. Implicit Type Casting (Widening)
        // Small type → Big type (Java does it automatically)

        int num = 10;
        double convertedNum = num; // int → double

        System.out.println("\nImplicit Casting:");
        System.out.println("int value: " + num);
        System.out.println("converted to double: " + convertedNum);


        // 2. Explicit Type Casting (Narrowing)
        // Big type → Small type (we do it manually)

        double value = 10.75;
        int reducedValue = (int) value; // double → int

        System.out.println("\nExplicit Casting:");
        System.out.println("double value: " + value);
        System.out.println("converted to int: " + reducedValue);


        // 3. Real DSA-style example 💡
        int a = 5;
        int b = 2;

        double result = a / b; // ❌ wrong way (still int division first)

        System.out.println("\nWrong Division (integer division issue):");
        System.out.println("5 / 2 = " + result);

        // Fix using type casting
        double correctResult = (double) a / b;

        System.out.println("\nCorrect Division using casting:");
        System.out.println("5 / 2 = " + correctResult);


        // 4. Character to int casting (ASCII magic 😈)
        char ch = 'A';
        int ascii = ch; // implicit casting

        System.out.println("\nChar to int:");
        System.out.println("Character: " + ch);
        System.out.println("ASCII value: " + ascii);
    }
}