public class LargestElement {

    // ----------------------------------------------------------
    // Method: Find the largest element in the array
    // Time Complexity: O(n)
    // - We scan through the array once to find the largest element.
    // Space Complexity: O(1)
    // - Only a few variables are used regardless of input size.
    // ----------------------------------------------------------
    static int getLargest(int[] arr) {
        int largest = arr[0];

        for (int var : arr) {
            if (var > largest) largest = var;
        }

        return largest;
    }

    // ----------------------------------------------------------
    // Main method to test getLargest
    // ----------------------------------------------------------
    public static void main(String[] args) {
        int[] numbers = {12, 45, 2, 67, 34};

        System.out.println("Largest element: " + getLargest(numbers));
        System.out.println("Time Complexity of getLargest(): O(n)");
    }
}
