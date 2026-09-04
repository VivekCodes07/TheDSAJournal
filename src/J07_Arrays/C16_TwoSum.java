package J07_Arrays;

public class C16_TwoSum {

    /*
    Two Sum:

    Given an array and a target, find two different elements
    whose sum is equal to the target.

    Logic:
    1. Take the first element using i.
    2. Compare it with every element after it using j.
    3. If arr[i] + arr[j] == target, we found the answer.
    4. Return the indices of those two elements.
    5. j starts from i + 1 so that:
       - We don't use the same element twice.
       - We don't check the same pair again.

    Example:
    arr = {2, 7, 11, 15}
    target = 9

    i = 0 → arr[i] = 2

    j = 1 → 2 + 7 = 9 ✓

    Therefore, return {0, 1}.

    Time Complexity: O(n²)
    Space Complexity: O(1)
    */

    public static int[] twoSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}