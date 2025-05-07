public class LargestElement {

    // Method to return the largest element in the array
    static int getLargest(int[] arr) {
        //Time Complexity : O(n)
        System.out.println("Time Complexity of getLargest(): O(n)");
        int largest = arr[0];

        for (int var : arr) if (var > largest) largest = var;

        return largest;
    }

    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = {12, 45, 2, 67, 34};

        // Call getLargest method and print the result
        System.out.println("Largest element: " + getLargest(numbers));

    }
}