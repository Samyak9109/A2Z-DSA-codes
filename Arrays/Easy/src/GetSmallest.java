public class GetSmallest {

    // ----------------------------------------------------------
    // Method: Find the smallest non-negative element in the array
    // Time Complexity: O(n)
    // - We traverse the array once to find the smallest non-negative value.
    // Space Complexity: O(1)
    // - Only a few variables are used regardless of input size.
    // ----------------------------------------------------------
    static int getSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        boolean found = false;

        for (int var : arr) {
            if (var >= 0 && var < smallest) {
                smallest = var;
                found = true;
            }
        }

        return found ? smallest : -1; // Return -1 if no non-negative number found
    }

    // ----------------------------------------------------------
    // Test the method
    // ----------------------------------------------------------
    public static void main(String[] args) {
        int[] numbers = {12, -5, 45, 2, 67, -9, 0};

        System.out.println("Smallest non-negative element: " + getSmallest(numbers));
        System.out.println("Time Complexity of getSmallest(): O(n)");
    }
}
