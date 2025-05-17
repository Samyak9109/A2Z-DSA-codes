public class RightRotateArray {

    // ----------------------------------------------------------
    // Method 1: Right Rotate by ONE Place
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateByOne(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int temp = arr[n - 1]; // Store last element

        // Shift all elements right by 1
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        arr[0] = temp; // Place last element at the beginning
    }

    // ----------------------------------------------------------
    // Method 2: Right Rotate by d using TEMP ARRAY
    // Time Complexity: O(n)
    // Space Complexity: O(d)
    public static void rotateByDTemp(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d == 0) return;

        d = d % n; // Handle d > n

        // Store last d elements in temp
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }

        // Shift remaining elements to the right
        for (int i = n - d - 1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }

        // Copy temp to the beginning
        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
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
    // Method 3: Right Rotate by d using REVERSAL ALGORITHM
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateByDReversal(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d == 0) return;

        d = d % n;

        // Step 1: Reverse last d elements
        reverse(arr, n - d, n - 1);
        // Step 2: Reverse first n-d elements
        reverse(arr, 0, n - d - 1);
        // Step 3: Reverse the whole array
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
        System.out.print("Right Rotate by 1 Place: ");
        for (int num : onePlace) System.out.print(num + " ");
        System.out.println();

        // Rotate by d using Temp Array
        rotateByDTemp(dTemp, d);
        System.out.print("Right Rotate by " + d + " Places (Temp): ");
        for (int num : dTemp) System.out.print(num + " ");
        System.out.println();

        // Rotate by d using Reversal Algorithm
        rotateByDReversal(dRev, d);
        System.out.print("Right Rotate by " + d + " Places (Reversal): ");
        for (int num : dRev) System.out.print(num + " ");
        System.out.println();
    }
}
