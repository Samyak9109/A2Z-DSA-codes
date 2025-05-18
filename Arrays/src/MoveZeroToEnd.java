import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroToEnd {

    // 🔸 Brute Force Method using ArrayList
    // Time Complexity: O(n)
    // - One pass to collect non-zeros, one to write them, one to fill zeros
    // Space Complexity: O(n)
    // - ArrayList holds non-zero elements
    static void moveZero(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();

        // Step 1: Collect all non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) temp.add(arr[i]);
        }

        // Step 2: Copy non-zero elements back to the original array
        int nz = temp.size();
        for (int i = 0; i < nz; i++) {
            arr[i] = temp.get(i);
        }

        // Step 3: Fill the remaining positions with zeros
        for (int i = nz; i < arr.length; i++) {
            arr[i] = 0;
        }
    }


    // 🔹 Optimal Method using in-place two-pointer technique
    // Time Complexity: O(n)
    // - Single traversal with constant-time swaps
    // Space Complexity: O(1)
    // - No extra memory used
    static void moveZeroOptimal(int[] arr) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap current non-zero with the earliest zero
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};  // For Brute Force
        int[] arr2 = {0, 1, 0, 3, 12};  // For Optimal

        System.out.println("Before moving zeros (Brute):  " + Arrays.toString(arr1));
        moveZero(arr1);
        System.out.println("After moving zeros (Brute):   " + Arrays.toString(arr1));

        System.out.println("Before moving zeros (Optimal): " + Arrays.toString(arr2));
        moveZeroOptimal(arr2);
        System.out.println("After moving zeros (Optimal):  " + Arrays.toString(arr2));
    }
}

