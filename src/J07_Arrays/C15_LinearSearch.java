package J07_Arrays;

public class C15_LinearSearch {
    public static void main(String[] args) {

        int[] arr = {12, 3, 65, 14, 56, 66, 14, 33};

        int target = 14;
        boolean found = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                found = true;
                System.out.println("Element found at index: " + i);
                break;
            }
        }

        if(found) {
            System.out.print("Target exists in array");
        } else {
            System.out.print("Target does not exist in array");
        }

    }
}
