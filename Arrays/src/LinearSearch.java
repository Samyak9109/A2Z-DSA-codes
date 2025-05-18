public class LinearSearch {

    // 🔍 Basic Linear Search: Returns the index of the target
    //
    // Time Complexity: O(n)
    // - In the worst case, we scan all elements to find the target
    // - Average case is also linear, especially when the target is near the end
    //
    // Space Complexity: O(1)
    // - No extra memory is used beyond a few variables

    static int linearSearch(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // Return the index when target is found
        }
        return -1; // Target not found
    }

    // 🧪 Main method to test the function
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4, 10};
        int target = 9;

        int index = linearSearch(target, arr);
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }
}
