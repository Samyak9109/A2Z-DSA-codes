public class GetSecondSmallest {

    // -----------------------------------------------------------------------
    // Method: getSecondSmallest
    // Description: Finds the second smallest non-negative element in an array.
    //
    // Time Complexity: O(n)
    // - One traversal of the array to find smallest and second smallest values.
    //
    // Space Complexity: O(1)
    // - Only a few extra variables are used (constant space).
    // -----------------------------------------------------------------------
    static int getSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int var : arr) {
            if (var < 0) continue; // Skip negative values

            if (var < smallest) {
                secondSmallest = smallest;
                smallest = var;
            } else if (var > smallest && var < secondSmallest) {
                secondSmallest = var;
            }
        }

        // If second smallest is not updated, return -1
        return (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;
    }

    // -----------------------------------------------------------------------
    // Main method for testing
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        int[] numbers = {12, -5, 45, 2, 67, -9, 0};

        System.out.println("Second Smallest non-negative element: " + getSecondSmallest(numbers));
    }
}
