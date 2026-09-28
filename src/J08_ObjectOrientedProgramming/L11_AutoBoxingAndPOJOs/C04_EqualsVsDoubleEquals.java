package J08_ObjectOrientedProgramming.L11_AutoBoxingAndPOJOs;

/*
I am learning the difference between == and .equals().

For primitive values:
    == compares the actual values.

For objects:
    == compares the references.

.equals():
    compares the logical/content value of objects
    when the class provides a proper equals() implementation.
*/

public class C04_EqualsVsDoubleEquals {

    public static void main(String[] args) {

        /*
        Primitive comparison

        Both variables directly contain primitive values.

        Stack:

        number1 = 10
        number2 = 10

        So == compares:

        10 == 10

        Result -> true
        */
        int number1 = 10;
        int number2 = 10;

        System.out.println(number1 == number2);

        System.out.println();


        /*
        String object comparison

        Here I am comparing objects.

        == checks whether both references
        point to the same object.

        .equals() checks the actual String content.
        */
        String name1 = new String("Vivek");
        String name2 = new String("Vivek");

        /*
        name1 and name2 contain references.

        Stack                         Heap

        name1 ───────────────────→ String("Vivek")

        name2 ───────────────────→ String("Vivek")

        These are two different objects.

        So:

        name1 == name2
        -> false
        */
        System.out.println("Using ==: " + (name1 == name2));

        /*
        .equals() compares the content of the
        two String objects.

        Both objects contain:

        "Vivek"

        So:

        name1.equals(name2)
        -> true
        */
        System.out.println("Using .equals(): " + name1.equals(name2));

        System.out.println();


        /*
        Integer objects

        Integer is a Wrapper class, so these
        variables contain references to objects.

        == checks references.
        .equals() checks the Integer values.
        */
        Integer value1 = 100;
        Integer value2 = 100;

        System.out.println("Integer == : " + (value1 == value2));

        System.out.println(
                "Integer .equals(): " + value1.equals(value2)
        );

        /*
        Important:

        Integer has caching for some commonly used
        values.

        Because of this, == with Integers can sometimes
        give true even when I am thinking about values.

        So I should NOT use == to compare Integer values.

        I should use:

        value1.equals(value2)
        */


        /*
        Final memory picture:

        Primitive:

        int a = 10;
        int b = 10;

        a == b
        ↓
        value comparison


        Object:

        String a = new String("Vivek");
        String b = new String("Vivek");

        a == b
        ↓
        reference comparison

        a.equals(b)
        ↓
        content/value comparison
        */
    }
}