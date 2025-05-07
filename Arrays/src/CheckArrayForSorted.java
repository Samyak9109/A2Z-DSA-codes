public class CheckArrayForSorted {

    // Method to check if array is sorted in non-decreasing order
    static void checkSorted(int[] arr) {
        boolean isSorted = true;

        // Loop through the array using indices
        for (int i = 1; i < arr.length; i++) {
            // If previous element is greater than current, it's not sorted
            if (arr[i - 1] > arr[i]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted)
            System.out.println("Array is sorted in non-decreasing order.");
        else
            System.out.println("Array is NOT sorted.");
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {1, 3, 2, 5};

        System.out.print("Checking sortedArray: ");
        checkSorted(sortedArray);

        System.out.print("Checking unsortedArray: ");
        checkSorted(unsortedArray);
    }
}
