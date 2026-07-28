package J07_Arrays;

import java.util.Arrays;

public class C08_ShallowCopyAndDeepCopy {

    public static void main(String[] args) {

        // Original array
        int[] original = {10, 20, 30, 40, 50};

        // -------------------- Shallow Copy --------------------
        System.out.println("===== Shallow Copy =====");

        int[] shallowCopy = original;

        shallowCopy[0] = 100;

        System.out.println("Original Array : " + Arrays.toString(original));
        System.out.println("Shallow Copy   : " + Arrays.toString(shallowCopy));

        // -------------------- Deep Copy --------------------
        System.out.println("\n===== Deep Copy =====");

        int[] deepCopy = Arrays.copyOf(original, original.length);

        deepCopy[1] = 200;

        System.out.println("Original Array : " + Arrays.toString(original));
        System.out.println("Deep Copy      : " + Arrays.toString(deepCopy));
    }
}

/*
 ======================= Things I Learned =======================

 Step 1:
 - As soon as main() starts, Java creates a Stack Frame for it.
 - All local variables like original, copy, and deepCopy live inside the Stack.

                     STACK
              +----------------+
              |    main()      |
              +----------------+

 Step 2:
 - When I created an array:

      int[] original = {10, 20, 30, 40};

 - Java stored the actual array inside the Heap because arrays are objects.
 - The variable 'original' only stores the reference (memory address) of that array.

                     STACK                          HEAP
              +----------------+          Address: 0x100
              | original ----+ |         +----------------------+
              +--------------|-+-------> | 10 | 20 | 30 | 40 |
                             |           +----------------------+
                             |
                      Reference (Address)

 Step 3: Shallow Copy

      int[] copy = original;

 - I first thought Java copies the whole array.
 - But Java only copies the reference (address).
 - Now both variables point to the same array in Heap.

                     STACK
              +----------------------+
              | original ---> 0x100  |
              | copy -------> 0x100  |
              +----------------------+
                          |
                          |
                          v
                     HEAP (0x100)
                +----------------------+
                | 10 | 20 | 30 | 40 |
                +----------------------+

 Step 4:

      copy[0] = 100;

 - JVM follows copy -> 0x100.
 - It changes index 0 of that same array.
 - Since original also points to 0x100, both variables see the updated value.

                     HEAP (0x100)
                +----------------------+
                |100 |20 |30 |40 |
                +----------------------+
                     ^            ^
                     |            |
                 original      copy

 That's why:

      System.out.println(original[0]);

 prints:

      100

 Step 5: Deep Copy

      int[] deepCopy = Arrays.copyOf(original, original.length);

 - Java creates a completely new array in a different memory location.
 - Every element is copied into that new array.

                     STACK
              +---------------------------+
              | original ---> 0x100       |
              | deepCopy --> 0x200        |
              +---------------------------+
                    |                 |
                    |                 |
                    v                 v

          HEAP (0x100)          HEAP (0x200)
      +----------------+     +----------------+
      |100|20|30|40|       |100|20|30|40|
      +----------------+     +----------------+

 - Now both arrays are completely independent.
 - Changing deepCopy won't affect original.

 Memory Trick:
 ----------------------------------------------------
 Primitive Types  -> Value is copied.
 Array/Object     -> Reference (address) is copied.

 Golden Rule:
 ----------------------------------------------------
 Stack stores the references (local variables).
 Heap stores the actual objects (arrays, strings, objects, etc.).

 Time Complexity:
 - Shallow Copy : O(1) // Only the reference is copied.
 - Deep Copy    : O(n) // Every element is copied into a new array.

 Space Complexity:
 - Shallow Copy : O(1)
 - Deep Copy    : O(n)
*/