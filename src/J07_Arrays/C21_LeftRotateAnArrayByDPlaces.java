package J07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class C21_LeftRotateAnArrayByDPlaces {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.print("Enter how many elements you want to rotate: ");
        int d = sc.nextInt();

        /*
        I use modulo so that d stays within the array length.

        Why?

        Rotating an array by its complete length
        brings it back to the original array.

        Example:
        d = 10
        arr.length = 7

        10 % 7 = 3

        So 10 rotations are the same as 3 rotations.
        */
        d = d % arr.length;

        /*
        Step 1: Store the first d elements.

        d = 3

        The first 3 elements need to move to the end,
        so I save them before shifting anything.

        arr:
        [1, 2, 3, 4, 5, 6, 7]

        tempArr:
        [1, 2, 3]
        */
        int[] tempArr = new int[d];

        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = arr[i];
        }

        System.out.println("Elements to rotate: " + Arrays.toString(tempArr));

        /*
        Step 2: Shift the remaining elements to the left.

        I start i from d because the first d elements
        are already stored in tempArr.

        d = 3

        So I start reading from index 3:

        arr:
        [1, 2, 3, 4, 5, 6, 7]
         0  1  2  3  4  5  6
                  ↑
                start

        I want:

        4 → index 0
        5 → index 1
        6 → index 2
        7 → index 3

        Each element has to move d positions to the left.

        New index = Current index - d

        That's why I use:

        arr[i - d] = arr[i]

        Here:
        i     = current/source index
        i - d = new/destination index

        Dry run:

        1. i = 3
           i - d = 3 - 3 = 0
           arr[0] = arr[3] → 4

        2. i = 4
           i - d = 4 - 3 = 1
           arr[1] = arr[4] → 5

        3. i = 5
           i - d = 5 - 3 = 2
           arr[2] = arr[5] → 6

        4. i = 6
           i - d = 6 - 3 = 3
           arr[3] = arr[6] → 7

        After shifting:

        [4, 5, 6, 7, 5, 6, 7]
        */
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        /*
        Step 3: Place the temporary elements at the back.

        After Step 2:

        [4, 5, 6, 7, _, _, _]

        I need to start filling from index 4.

        Starting index = arr.length - d
                       = 7 - 3
                       = 4

        Why arr.length - d?

        The array has 7 positions and I have to
        place 3 saved elements at the end.

        So the last 3 positions are:

        index 4, 5, 6

        I then add i to move through these positions.

        Formula:

        Destination index = arr.length - d + i

        Dry run:

        1. i = 0
           7 - 3 + 0 = 4
           arr[4] = tempArr[0] → 1

        2. i = 1
           7 - 3 + 1 = 5
           arr[5] = tempArr[1] → 2

        3. i = 2
           7 - 3 + 2 = 6
           arr[6] = tempArr[2] → 3

        Final:

        [4, 5, 6, 7, 1, 2, 3]
        */
        for (int i = 0; i < tempArr.length; i++) {
            arr[arr.length - d + i] = tempArr[i];
        }

        System.out.println("Rotated Array: " + Arrays.toString(arr));

        sc.close();
    }
}