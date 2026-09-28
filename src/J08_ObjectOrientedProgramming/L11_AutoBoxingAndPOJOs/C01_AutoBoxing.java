package J08_ObjectOrientedProgramming.L11_AutoBoxingAndPOJOs;

/*
I am learning how primitive values and
Wrapper objects are converted into each other.

Primitive -> Wrapper
    int -> Integer

Wrapper -> Primitive
    Integer -> int

When Java performs these conversions automatically,
they are called AutoBoxing and AutoUnboxing.
*/

public class C01_AutoBoxing {

    public static void main(String[] args) {

        /*
        First I have a primitive value.

        x directly stores the value 10.

        Stack
        x = 10
        */
        int x = 10;


        /*
        AutoBoxing

        I am assigning an int to an Integer.

        Java automatically converts:

        int
         ↓
        Integer object

        y now stores a reference to that Integer object.
        */
        Integer y = x;

        System.out.println("AutoBoxed value: " + y);


        /*
        AutoUnboxing

        Now y is an Integer object.

        I assign it to an int.

        Java automatically converts:

        Integer object
             ↓
        int primitive

        So z directly stores the primitive value.
        */
        int z = y;

        System.out.println("AutoUnboxed value: " + z);


        /*
        Boxing

        Here I am doing Boxing manually.

        I explicitly use Integer.valueOf().

        int value
             ↓
        Integer.valueOf()
             ↓
        Integer object
        */
        Integer value = Integer.valueOf(20);

        System.out.println("Boxed value: " + value);


        /*
        Unboxing

        Here I am manually converting
        the Integer object back into int.

        Integer object
             ↓
        intValue()
             ↓
        int primitive
        */
        int value2 = value.intValue();

        System.out.println("Unboxed value: " + value2);


        /*
        Now I am comparing Integer and int.

        value  -> Integer
        value2 -> int

        Because value2 is a primitive,
        Java unboxes value before using ==.

        So internally this becomes:

        int == int
        20 == 20
        */
        System.out.println(value == value2);


        /*
        equals() works differently.

        value is an Integer object.

        equals() checks the value represented
        by the Integer object.

        value2 is an int, so Java boxes it
        into an Integer before passing it
        to equals().

        Integer.equals(Integer)
        */
        System.out.println(value.equals(value2));
    }
}