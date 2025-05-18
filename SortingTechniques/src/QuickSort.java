import java.util.*;

public class QuickSort {

    // Function to partition the list around a pivot
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low); // Choose the first element as pivot
        int i = low + 1;          // Start i from the next element
        int j = high;             // Start j from the end

        // Continue until pointers cross
        while (i <= j) {
            // Move i to the right until an element > pivot is found
            while (i <= high && arr.get(i) <= pivot) {
                i++;
            }

            // Move j to the left until an element <= pivot is found
            while (j >= low && arr.get(j) > pivot) {
                j--;
            }

            // If i is still to the left of j, swap them
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Place the pivot in its correct sorted position
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        // Return the index of the pivot
        return j;
    }

    // Recursive QuickSort function to sort subarrays
    static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            // Partition the list and get pivot index
            int pIndex = partition(arr, low, high);

            // Recursively sort the left part
            quickSort(arr, low, pIndex - 1);

            // Recursively sort the right part
            quickSort(arr, pIndex + 1, high);
        }
    }

    // Entry point function to start QuickSort
    public static List<Integer> quickSort(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
        return arr; // Return the sorted list
    }

    // Main function to test the sorting
    public static void main(String[] args) {
        // Initialize an unsorted list
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3));
        int n = arr.size();

        // Print the list before sorting
        System.out.println("Before Using QuickSort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }

        // Sort the list using QuickSort
        quickSort(arr);

        // Print the list after sorting
        System.out.println("\nAfter Using QuickSort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(); // Move to new line after output
    }
}
