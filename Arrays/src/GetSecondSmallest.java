public class GetSecondSmallest {
    // Method to find the second smallest non-negative element
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

        // Check if second smallest was updated
        return (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;
    }

    // Test the method
    public static void main(String[] args) {
        int[] numbers = {12, -5, 45, 2, 67, -9, 0};

        System.out.println("Second Smallest non-negative element: " + getSecondSmallest(numbers));
        System.out.println("Time Complexity of getSecondSmallest(): O(n)");
    }
}
