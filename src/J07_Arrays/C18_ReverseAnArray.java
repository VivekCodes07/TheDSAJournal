package J07_Arrays;

import java.util.Arrays;

public class C18_ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        // indexes:  0  1, 2  3  4  5
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.print(Arrays.toString(arr));
    }
}

/*
How I think about reversing an array:

I don't create a new array. Instead, I reverse the same
array by swapping elements from both ends and moving
towards the middle.

For every iteration, i represents the position from the
LEFT side.

The matching position from the RIGHT side is:

    arr.length - 1 - i

For this array:

    [1, 2, 3, 4, 5, 6]
     0  1  2  3  4  5    ← indexes

Iteration 1:
    i = 0
    left  = arr[0] = 1
    right = arr[5] = 6

    Swap 1 ↔ 6

    [6, 2, 3, 4, 5, 1]

Iteration 2:
    i = 1
    left  = arr[1] = 2
    right = arr[4] = 5

    Swap 2 ↔ 5

    [6, 5, 3, 4, 2, 1]

Iteration 3:
    i = 2
    left  = arr[2] = 3
    right = arr[3] = 4

    Swap 3 ↔ 4

    [6, 5, 4, 3, 2, 1]

Now the array is reversed.

Why do I use arr.length / 2?

Because every iteration fixes TWO positions at once:
one position from the left and its matching position
from the right.

So for 6 elements:

    6 / 2 = 3 swaps

After those 3 swaps, every element is already in its
correct reversed position. Processing the other half
would only swap the elements back again.

The temp variable is needed because I must temporarily
store one value before replacing it during the swap.

So the complete mental model is:

    LEFT  →  swap  ←  RIGHT
             ↓
        move towards
         the middle
             ↓
          repeat
             ↓
       array reversed

Time Complexity: O(n)
Space Complexity: O(1)
*/
