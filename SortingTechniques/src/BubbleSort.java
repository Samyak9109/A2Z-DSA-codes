public class BubbleSort {

    // Iterative Bubble Sort
    /*
     * Time Complexity:
     * Best Case: O(n) — when the array is already sorted and no swaps happen (due to early termination).
     * Worst Case: O(n^2) — when the array is reverse sorted, requires maximum swaps.
     * Average Case: O(n^2) — random order array.
     *
     * Space Complexity: O(1) — in-place sorting, no extra space apart from few variables.
     */
    static void bubbleSort(int[] arr, int n) {
        boolean swapped;

        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for pairwise comparison
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swapping arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // Mark that a swap happened
                }
            }

            // If no swaps happened, the array is already sorted - early termination
            if (!swapped) {
                System.out.println("Early termination after " + (i + 1) + " passes");
                break;
            }
        }
    }

    // Recursive Bubble Sort
    /*
     * Time Complexity:
     * Best Case: O(n^2) — this implementation does not have early termination optimization.
     * Worst Case: O(n^2)
     * Average Case: O(n^2)
     *
     * Space Complexity: O(n) — recursion call stack uses O(n) space due to n recursive calls.
     */
    static void bubbleSortRecursive(int[] arr, int n) {
        // Base case: if array has only one element
        if (n == 1) return;

        // Perform one full pass to push largest element to the end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for remaining unsorted part
        bubbleSortRecursive(arr, n - 1);
    }

    // Utility method to print the array
    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // Best case - already sorted array for iterative method
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Iterative Bubble Sort - Already Sorted Array:");
        bubbleSort(sortedArray, sortedArray.length);
        printArray(sortedArray);

        // Worst case - reverse sorted array for recursive method
        int[] reverseArray = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("\nRecursive Bubble Sort - Reverse Sorted Array:");
        bubbleSortRecursive(reverseArray, reverseArray.length);
        printArray(reverseArray);

        // Average case - random array for iterative method
        int[] randomArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nIterative Bubble Sort - Random Array:");
        bubbleSort(randomArray, randomArray.length);
        printArray(randomArray);
    }
}
