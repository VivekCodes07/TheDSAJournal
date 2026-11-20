package J02_Operators;

public class C01_LogicalOperators {
        public static void main(String[] args) {
            int age = 22;
            boolean hasLicense = true;
            boolean hasTrafficViolation = false;

            // 1. Logical AND (&&)
            if (age >= 18 && hasLicense) {
                System.out.println("You are legally allowed to drive.");
            }

            // 2. Logical OR (||)
            if (age < 18 || hasTrafficViolation) {
                System.out.println("High insurance risk check triggered.");
            }

            // 3. Logical NOT (!)
            if (!hasTrafficViolation) {
                System.out.println("You have a clean driving record.");
            }
        }
    }

