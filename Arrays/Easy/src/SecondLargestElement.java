public class SecondLargestElement {

    /**
     * Method to return the second-largest non-negative element in the array.
     * Ignores negative values.
     *
     * Time Complexity: O(n)
     *  - Single pass through the array.
     *
     * Space Complexity: O(1)
     *  - Uses only a fixed number of variables.
     *
     * @param arr Input integer array
     * @return second largest non-negative element or -1 if it doesn't exist
     */
    static int getSecondLargest(int[] arr) {
        int largest = -1;        // Initialize to -1 to handle negative numbers properly
        int secondLargest = -1;  // Initialize to -1 to indicate no second largest found yet

        for (int var : arr) {
            if (var < 0) continue;  // Skip negative numbers

            if (var > largest) {
                secondLargest = largest;
                largest = var;
            } else if (var > secondLargest && var < largest) {
                secondLargest = var;
            }
        }

        return secondLargest;
    }

    // Main method to test getSecondLargest
    public static void main(String[] args) {
        int[] numbers = {12, 45, 2, 67, 34};
        System.out.println("Second Largest element: " + getSecondLargest(numbers));
    }
}
