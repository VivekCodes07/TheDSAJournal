package J07_Arrays;

import java.util.Arrays;

public class C19_ReverseAnArray_TwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }
}

/*
Flow:

    left = 0, right = 5
        ↓
      swap
        ↓
left = 1, right = 4
        ↓
      swap
        ↓
left = 2, right = 3
        ↓
      swap
        ↓
left = 3, right = 2
        ↓
   left < right ❌
        ↓
       DONE
*/

/*
To reverse the array, I place two pointers at opposite ends:
    left  → starts at the first index
    right → starts at the last index

In every iteration, I swap the elements at left and right.
Then I move both pointers towards the middle:

    left++   → moves one step forward
    right--  → moves one step backward

For example:

    [1, 2, 3, 4, 5, 6]
     ↑              ↑
    left           right

    Swap → [6, 2, 3, 4, 5, 1]

    [6, 2, 3, 4, 5, 1]
        ↑        ↑
       left     right

    Swap → [6, 5, 3, 4, 2, 1]

    [6, 5, 3, 4, 2, 1]
            ↑ ↑
         left right

    Swap → [6, 5, 4, 3, 2, 1]

I keep doing this while left < right.
Once the pointers meet or cross, every element has
already been placed in its reversed position.

temp is used to safely store one value while swapping
the two elements.

This reverses the array in-place, so I don't need another
array.

Time Complexity: O(n)
Space Complexity: O(1)
*/