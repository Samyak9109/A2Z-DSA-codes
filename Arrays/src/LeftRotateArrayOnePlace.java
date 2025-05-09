public class LeftRotateArrayOnePlace {

    // Function to left rotate the array by one position
    static void leftRotateArray(int[] arr) {
        int temp = arr[0]; // Store first element
        int n = arr.length;

        // Shift all elements one position to the left
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end
        arr[n - 1] = temp;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        leftRotateArray(arr);

        System.out.println("\nArray after left rotation by one position:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

