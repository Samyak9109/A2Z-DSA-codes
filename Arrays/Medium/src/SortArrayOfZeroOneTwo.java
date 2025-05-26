import java.util.*;

public class SortArrayOfZeroOneTwo {

    // ---------------------------------------------
    // Brute Force Method:
    // Time Complexity: O(n) -> Two passes: one for counting, one for overwriting.
    // Space Complexity: O(1) -> No extra space used, just counters.
    // Logic: Count the number of 0s, 1s, and 2s, then overwrite the list.
    // ---------------------------------------------
    public static void sortBrute(ArrayList<Integer> arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Count number of 0s, 1s and 2s
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Overwrite the list with the counted values
        int index = 0;
        for (int i = 0; i < count0; i++) arr.set(index++, 0);
        for (int i = 0; i < count1; i++) arr.set(index++, 1);
        for (int i = 0; i < count2; i++) arr.set(index++, 2);
    }

    // ---------------------------------------------
    // Better Method:
    // Time Complexity: O(n) -> Three passes: one each for 0s, 1s, and 2s.
    // Space Complexity: O(n) -> Uses an extra temporary ArrayList.
    // Logic: Create a new list and add all 0s, then 1s, then 2s, then copy back.
    // ---------------------------------------------
    public static void sortBetter(ArrayList<Integer> arr) {
        ArrayList<Integer> temp = new ArrayList<>();

        // Add all 0s, then 1s, then 2s
        for (int num : arr) if (num == 0) temp.add(0);
        for (int num : arr) if (num == 1) temp.add(1);
        for (int num : arr) if (num == 2) temp.add(2);

        // Copy back to original list
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, temp.get(i));
        }
    }

    // ---------------------------------------------
    // Optimal Method (Dutch National Flag Algorithm):
    // Time Complexity: O(n) -> Single traversal using three pointers.
    // Space Complexity: O(1) -> In-place swapping.
    // Logic: Use three pointers (low, mid, high) to place 0s at start,
    // 2s at end, and 1s in the middle.
    // ---------------------------------------------
    public static void sortOptimal(ArrayList<Integer> arr) {
        int low = 0, mid = 0, high = arr.size() - 1;

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // Swap arr[low] and arr[mid], move both forward
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                // Just move mid
                mid++;
            } else {
                // Swap arr[mid] and arr[high], move high backward
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                high--;
            }
        }
    }

    // Main method to test all three sorting approaches
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 2, 1, 2, 0, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(arr1); // copy for better method
        ArrayList<Integer> arr3 = new ArrayList<>(arr1); // copy for optimal method

        System.out.println("Original array: " + arr1);

        // Apply Brute Force
        sortBrute(arr1);
        System.out.println("Sorted using Brute Force: " + arr1);

        // Apply Better Method
        sortBetter(arr2);
        System.out.println("Sorted using Better Method: " + arr2);

        // Apply Optimal Method
        sortOptimal(arr3);
        System.out.println("Sorted using Optimal Method: " + arr3);
    }
}
