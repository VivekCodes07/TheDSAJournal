package J07_Arrays;

import java.util.Arrays;

public class C20_LeftRotateAnArrayByOneElement {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Before rotation: " + Arrays.toString(arr));

        /*
        Store the first element because it will be
        overwritten when we start shifting the elements.
        */
        int temp = arr[0];

        /*
        Shift every element one position to the left.

        arr[1] moves to arr[0]
        arr[2] moves to arr[1]
        arr[3] moves to arr[2]
        arr[4] moves to arr[3]
        */
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        /*
        The first element is safely stored in temp.
        Put it at the last position to complete the rotation.
        */
        arr[arr.length - 1] = temp;

        System.out.print("After rotation:  " + Arrays.toString(arr));
    }
}