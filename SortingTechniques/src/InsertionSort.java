public class InsertionSort {

    // First implementation of insertion sort
    /*
     * Time Complexity:
     * Best Case: O(n) — when the array is already sorted, the inner while loop runs minimal times.
     * Worst Case: O(n^2) — when the array is reverse sorted, maximum shifts/swaps happen.
     * Average Case: O(n^2) — average number of shifts/swaps.
     *
     * Space Complexity: O(1) — in-place sorting, uses constant extra space.
     */
    static void insertionSort(int[] arr) {
        int n = arr.length;

        // Loop through all elements from left to right
        for (int i = 0; i <= n - 1; i++) {
            int j = i;

            // Compare current element with all its previous elements
            while (j > 0 && arr[j - 1] > arr[j]) {
                // Swap arr[j] and arr[j-1] if they are in wrong order
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--; // Move one position back
            }
        }
    }

    // Alternative (and more common) implementation using a 'key'
    /*
     * Time Complexity:
     * Best Case: O(n) — when the array is already sorted, minimal shifts.
     * Worst Case: O(n^2) — when the array is reverse sorted.
     * Average Case: O(n^2)
     *
     * Space Complexity: O(1) — in-place sorting.
     */
    static void insertionSortAlternative(int[] arr) {
        int n = arr.length;

        // Start from the second element
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted in the sorted part
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--; // Move backwards
            }

            // Place the key at its correct sorted position
            arr[j + 1] = key;
        }
    }

    // Main method to test both implementations
    public static void main(String[] args) {

        // Test 1: Unsorted array with random elements
        int[] arr1 = {12, 11, 13, 5, 6};
        System.out.println("Original array:");
        printArray(arr1);

        // Apply first insertion sort implementation
        insertionSort(arr1);
        System.out.println("Sorted array (original implementation):");
        printArray(arr1);

        // Test 2: Using the alternative (key-based) version
        int[] arr2 = {12, 11, 13, 5, 6};
        insertionSortAlternative(arr2);
        System.out.println("Sorted array (alternative implementation):");
        printArray(arr2);

        // Test 3: Best-case input (already sorted array)
        int[] sortedArr = {1, 2, 3, 4, 5};
        long startTime = System.nanoTime();
        insertionSort(sortedArr);
        long endTime = System.nanoTime();
        System.out.println("Time taken for sorted array (best case): " + (endTime - startTime) + " ns");

        // Test 4: Worst-case input (reverse sorted array)
        int[] reverseArr = {5, 4, 3, 2, 1};
        startTime = System.nanoTime();
        insertionSort(reverseArr);
        endTime = System.nanoTime();
        System.out.println("Time taken for reverse sorted array (worst case): " + (endTime - startTime) + " ns");
    }

    // Utility function to print an array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
