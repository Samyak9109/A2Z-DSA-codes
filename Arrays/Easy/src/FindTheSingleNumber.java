import java.util.HashMap;
import java.util.Map;

public class FindTheSingleNumber {

    // Brute Force method: Check each element by counting occurrences
    // Time Complexity: O(n^2) because of nested loops
    // Space Complexity: O(1) no extra space used except variables
    static int getSingleElementBrute(int[] arr) {
        // Current number to check
        for (int num : arr) {
            int cnt = 0;       // Counter for frequency
            for (int i : arr) {
                if (i == num) cnt++;  // Increment count if match found
            }
            if (cnt == 1) return num;  // If count is 1, return the number
        }
        return -1;  // If no single element found
    }

//-----------------------------------------------------------------------------------------------------------------------------

    // Better method: Use a HashMap to count frequencies
    // Time Complexity: NlogM + O(n/2+1)
    // Space Complexity: O(n) for the hashmap
    static int getSingleElementBetter(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();  // Create map to store frequencies

        for (int j : arr) {
            int value = mpp.getOrDefault(j, 0);  // Get current count or 0
            mpp.put(j, value + 1);  // Increment and update count
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {  // Traverse map entries
            if (it.getValue() == 1) {  // If frequency is 1
                return it.getKey();   // Return that key
            }
        }
        return -1;  // If no single element found
    }

//-----------------------------------------------------------------------------------------------------------------------------


    // Optimal method: Use XOR property
    // XOR of a number with itself is 0, and XOR of a number with 0 is the number itself
    // So XORing all numbers cancels out duplicates and leaves the single number
    // Time Complexity: O(n), Space Complexity: O(1)
    static int getSingleElementOptimal(int[] arr) {
        int result = 0;  // Initialize result as 0
        for (int num : arr) {
            result ^= num;  // XOR all elements
        }
        return result;  // Result holds the single element
    }

//-----------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};  // Input array

        int ansBrute = getSingleElementBrute(arr);  // Call brute method
        System.out.println("Brute Force: The single element is: " + ansBrute);

        int ansBetter = getSingleElementBetter(arr);  // Call better method
        System.out.println("Better (HashMap): The single element is: " + ansBetter);

        int ansOptimal = getSingleElementOptimal(arr);  // Call optimal method
        System.out.println("Optimal (XOR): The single element is: " + ansOptimal);
    }
}
