package J02_Operators;

public class C02_BitwiseOperators {
    public static void main(String[] args) {

        /*
        ============================
             BITWISE OPERATORS
        ============================

        Bitwise operators work directly on the individual bits
        of an integer's binary representation.

        Example:

        5 = 0101
        3 = 0011

        Instead of operating on the complete decimal values,
        bitwise operators work with the individual bits.

        Operators covered:

        &   Bitwise AND
        |   Bitwise OR
        ^   Bitwise XOR
        ~   Bitwise NOT
        <<  Left Shift
        >>  Signed Right Shift
        >>> Unsigned Right Shift
        */

        int a = 5;
        int b = 3;

        System.out.println("a = " + a);
        System.out.println("b = " + b);


        /*
        ============================
        1. BITWISE AND (&)
        ============================

        AND compares the corresponding bits of two numbers.

        Rule:

        1 & 1 = 1
        1 & 0 = 0
        0 & 1 = 0
        0 & 0 = 0

        The result is 1 only when BOTH bits are 1.

        Example:

          0101   (5)
        & 0011   (3)
        ------
          0001   (1)

        Therefore:

        5 & 3 = 1
        */

        int andResult = a & b;

        System.out.println("\nBitwise AND (&)");
        System.out.println("5 & 3 = " + andResult);


        /*
        ============================
        2. BITWISE OR (|)
        ============================

        OR compares the corresponding bits of two numbers.

        Rule:

        1 | 1 = 1
        1 | 0 = 1
        0 | 1 = 1
        0 | 0 = 0

        The result is 1 when AT LEAST ONE of the bits is 1.

        Example:

          0101   (5)
        | 0011   (3)
        ------
          0111   (7)

        Therefore:

        5 | 3 = 7
        */

        int orResult = a | b;

        System.out.println("\nBitwise OR (|)");
        System.out.println("5 | 3 = " + orResult);


        /*
        ============================
        3. BITWISE XOR (^)
        ============================

        XOR means Exclusive OR.

        It produces 1 only when the two bits are DIFFERENT.

        Rule:

        1 ^ 1 = 0
        1 ^ 0 = 1
        0 ^ 1 = 1
        0 ^ 0 = 0

        Easy way to remember:

        Same bits      -> 0
        Different bits -> 1

        Example:

          0101   (5)
        ^ 0011   (3)
        ------
          0110   (6)

        Therefore:

        5 ^ 3 = 6
        */

        int xorResult = a ^ b;

        System.out.println("\nBitwise XOR (^)");
        System.out.println("5 ^ 3 = " + xorResult);


        /*
        ============================
        4. BITWISE NOT (~)
        ============================

        NOT works on only one value.

        It flips every bit:

        0 becomes 1
        1 becomes 0

        Example:

        5  = 00000101
        ~5 = 11111010

        Java uses Two's Complement to represent signed integers.

        Because of this:

        ~n = -(n + 1)

        Therefore:

        ~5 = -(5 + 1)
           = -6
        */

        int notResult = ~a;

        System.out.println("\nBitwise NOT (~)");
        System.out.println("~5 = " + notResult);


        /*
        ============================
        5. LEFT SHIFT (<<)
        ============================

        Left shift moves the bits towards the left.

        Example:

        5 = 0101

        5 << 1

        0101 -> 1010

        1010 = 10

        Therefore:

        5 << 1 = 10

        For positive numbers, shifting left by one position
        is generally equivalent to multiplying by 2.

        The number after << tells Java how many positions
        the bits should be shifted.
        */

        int leftShiftResult = a << 1;

        System.out.println("\nLeft Shift (<<)");
        System.out.println("5 << 1 = " + leftShiftResult);


        /*
        ============================
        6. SIGNED RIGHT SHIFT (>>)
        ============================

        Right shift moves the bits towards the right.

        Example:

        5 = 0101

        5 >> 1

        0101 -> 0010

        0010 = 2

        Therefore:

        5 >> 1 = 2

        For positive numbers, shifting right by one position
        is generally equivalent to integer division by 2.

        The >> operator is a SIGNED right shift.

        For negative numbers, Java preserves the sign by
        filling the empty positions with the sign bit.
        */

        int rightShiftResult = a >> 1;

        System.out.println("\nSigned Right Shift (>>)");
        System.out.println("5 >> 1 = " + rightShiftResult);


        /*
        ============================
        7. UNSIGNED RIGHT SHIFT (>>>)
        ============================

        The unsigned right shift also moves bits towards the right.

        The important difference is what happens to the
        empty positions on the left.

        >>  -> preserves the sign bit
        >>> -> fills the empty positions with 0

        This difference becomes especially important
        when working with negative numbers.

        Because >>> fills with 0, applying it to a negative
        number can produce a large positive value.
        */

        int negative = -8;
        int unsignedRightShiftResult = negative >>> 1;

        System.out.println("\nUnsigned Right Shift (>>>)");
        System.out.println("-8 >>> 1 = " + unsignedRightShiftResult);


        /*
        ============================
             QUICK RECAP
        ============================

        &   -> Both bits must be 1
        |   -> At least one bit must be 1
        ^   -> Bits must be different
        ~   -> Flips every bit
        <<  -> Shifts bits to the left
        >>  -> Shifts right and preserves the sign
        >>> -> Shifts right and fills with 0

        The key idea:

        Bitwise operators work with BITS,
        not with decimal digits.
        */
    }
}