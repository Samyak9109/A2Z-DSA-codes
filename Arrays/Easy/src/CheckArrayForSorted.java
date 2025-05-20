public class CheckArrayForSorted {

    // -------------------------------------------------------------------
    // Method 1: Iterative approach using a for loop
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static boolean isSortedIterative(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // -------------------------------------------------------------------
    // Method 2: Recursive approach
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to recursive stack
    static boolean isSortedRecursive(int[] arr, int index) {
        if (index == arr.length - 1) return true;

        if (arr[index] > arr[index + 1]) return false;

        return isSortedRecursive(arr, index + 1);
    }

    // -------------------------------------------------------------------
    // Method 3: Using Java 8 Streams (for learning)
    // Time Complexity: O(n)
    // Space Complexity: O(1) – Internal stream usage is abstracted
    static boolean isSortedStream(int[] arr) {
        return java.util.stream.IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] <= arr[i + 1]);
    }

    // -------------------------------------------------------------------
    // Method 4: Brute-force (Nested Loop) – For learning, not efficient
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    static boolean isSortedBruteForce(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // -------------------------------------------------------------------
    // Wrapper to print results
    static void checkSorted(String methodName, boolean result) {
        System.out.println(methodName + ": " +
                (result ? "Array is sorted." : "Array is NOT sorted."));
    }

    // -------------------------------------------------------------------
    // Main method to test all
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {1, 3, 2, 5};

        System.out.println("Testing with sortedArray:");
        checkSorted("Iterative", isSortedIterative(sortedArray));
        checkSorted("Recursive", isSortedRecursive(sortedArray, 0));
        checkSorted("Stream", isSortedStream(sortedArray));
        checkSorted("BruteForce", isSortedBruteForce(sortedArray));

        System.out.println("\nTesting with unsortedArray:");
        checkSorted("Iterative", isSortedIterative(unsortedArray));
        checkSorted("Recursive", isSortedRecursive(unsortedArray, 0));
        checkSorted("Stream", isSortedStream(unsortedArray));
        checkSorted("BruteForce", isSortedBruteForce(unsortedArray));
    }
}
