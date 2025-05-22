import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {

    // Brute Force Approach
    // Time Complexity: O(N^3)
    //   - Three nested loops: i, j, and l for summing elements in every subarray
    // Space Complexity: O(1)
    //   - No extra data structures used
    static int getLongestSubarrayBrute(int[] arr, int k) {
        int n = arr.length;
        int len = 0;

        // Try all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l]; // Calculate subarray sum
                }
                if (sum == k) {
                    len = Math.max(len, j - i + 1); // Update max length
                }
            }
        }
        return len;
    }


    // Better Approach
    // Time Complexity: O(N^2)
    //   - Two nested loops, inner one accumulates sum incrementally
    // Space Complexity: O(1)
    //   - No extra space used
    static int getLongestSubarrayBetter(int[] arr, int k) {
        int n = arr.length;
        int len = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // Accumulate sum
                if (sum == k) {
                    len = Math.max(len, j - i + 1); // Update max length
                }
            }
        }
        return len;
    }


    // Optimal Approach using Prefix Sum and HashMap
    // Time Complexity: O(N)
    //   - Single loop over array with constant time hash map operations
    // Space Complexity: O(N)
    //   - HashMap stores prefix sums
    static int getLongestSubarrayOptimal(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Running sum

            if (sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem); // Calculate subarray length
                maxLen = Math.max(maxLen, len);
            }

            // Store only first occurrence of this sum
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    // Optimal Approach for only non-negative elements using 2 pointers (Sliding Window)
    // Time Complexity: O(N)
    //   - Each element visited at most twice: once by right, once by left
    // Space Complexity: O(1)
    //   - No extra space used
    public static int getLongestSubarrayOptimal2(int[] a, long k) {
        int n = a.length;
        int left = 0, right = 0;
        long sum = a[0];
        int maxLen = 0;

        while (right < n) {
            // Shrink window from the left if sum > k
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // Check if sum == k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand window to the right
            right++;
            if (right < n) {
                sum += a[right];
            }
        }

        return maxLen;
    }


    // Main method to test all approaches
    public static void main(String[] args) {
        int[] a = {-1, 1, 1};
        int k = 1;

        System.out.println("Input Array: {-1, 1, 1}, Target Sum = 1");

        int bruteLen = getLongestSubarrayBrute(a, k);
        System.out.println("Brute Force -> Longest subarray length: " + bruteLen);

        int betterLen = getLongestSubarrayBetter(a, k);
        System.out.println("Better Approach -> Longest subarray length: " + betterLen);

        int optimalLen = getLongestSubarrayOptimal(a, k);
        System.out.println("Optimal Approach (HashMap) -> Longest subarray length: " + optimalLen);

        int optimal2Len = getLongestSubarrayOptimal2(a, k); // Only valid if all elements are non-negative
        System.out.println("Optimal Approach 2 (2 pointers) -> Longest subarray length: " + optimal2Len);
    }
}
