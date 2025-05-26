import java.util.ArrayList;
import java.util.*;

// Helper class containing merge sort methods
class Merge {

    // Function to merge two sorted halves of the array
    public static void merge(int[] arr, int low, int mid, int high) {
        // Temporary list to store merged elements
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;       // Starting index of left half
        int right = mid + 1;  // Starting index of right half

        // Compare and merge elements from both halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]); // Add smaller element
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements from the left half (if any)
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements from the right half (if any)
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy the sorted elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low); // Adjust index for temp list
        }
    }

    // Recursive merge sort function
    public static void mergeSort(int[] arr, int low, int high) {
        // Base case: if the subarray has one or no element, it's already sorted
        if (low >= high) return;

        int mid = (low + high) / 2; // Find the middle index

        // Recursively sort the left half
        mergeSort(arr, low, mid);

        // Recursively sort the right half
        mergeSort(arr, mid + 1, high);

        // Merge the sorted halves
        merge(arr, low, mid, high);
    }
}

// Main class containing the main method
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define the input array
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };

        // Print array before sorting
        System.out.println("Before sorting array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call merge sort to sort the array
        Merge.mergeSort(arr, 0, n - 1);

        // Print array after sorting
        System.out.println("After sorting array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
