public class LeftRotateArray {

    // ----------------------------------------------------------
    // Method 1: Left Rotate by ONE Place
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateByOne(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int temp = arr[0]; // Store first element

        // Shift elements left by 1
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = temp; // Place first element at the end
    }

    // ----------------------------------------------------------
    // Method 2: Left Rotate by d using TEMP ARRAY
    // Time Complexity: O(n)
    // Space Complexity: O(d)
    public static void rotateByDTemp(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d == 0) return;

        d = d % n; // Handle d > n

        // Store first d elements in temp
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // Shift remaining elements left
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Copy temp elements to end
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }

    // ----------------------------------------------------------
    // Helper Method: Reverse a portion of the array
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // ----------------------------------------------------------
    // Method 3: Left Rotate by d using REVERSAL ALGORITHM
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateByDReversal(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d == 0) return;

        d = d % n;

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);
        // Step 2: Reverse remaining elements
        reverse(arr, d, n - 1);
        // Step 3: Reverse whole array
        reverse(arr, 0, n - 1);
    }

    // ----------------------------------------------------------
    // Main Method to Test All Rotations
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7};
        int[] onePlace = original.clone();
        int[] dTemp = original.clone();
        int[] dRev = original.clone();
        int d = 3;

        // Rotate by One
        rotateByOne(onePlace);
        System.out.print("Left Rotate by 1 Place: ");
        for (int num : onePlace) System.out.print(num + " ");
        System.out.println();

        // Rotate by d using Temp Array
        rotateByDTemp(dTemp, d);
        System.out.print("Left Rotate by " + d + " Places (Temp): ");
        for (int num : dTemp) System.out.print(num + " ");
        System.out.println();

        // Rotate by d using Reversal Algorithm
        rotateByDReversal(dRev, d);
        System.out.print("Left Rotate by " + d + " Places (Reversal): ");
        for (int num : dRev) System.out.print(num + " ");
        System.out.println();
    }
}
