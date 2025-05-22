import java.util.HashMap;
import java.util.Map;

//Works for both negatives and positives

public class LongestSubarraySumK {

    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    // Reason: Three nested loops to try every subarray and calculate sum without extra space
    static int getLongestSubarrayBrute(int[] arr, int k) {
        int n = arr.length;
        int len = 0;

        // Try all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int sum = 0;
                for (int l = i; l <= j; l++) sum += arr[l]; // Calculate subarray sum

                if (sum == k) len = Math.max(len, j - i + 1); // Update max length
            }
        }
        return len;
    }


    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    // Reason: Two nested loops, sum is maintained incrementally, no extra data structures used
    static int getLongestSubarrayBetter(int[] arr, int k) {
        int n = arr.length;
        int len = 0;

        // Try all starting points
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // Keep adding elements to sum
                if (sum == k) len = Math.max(len, j - i + 1); // Check and update max length
            }
        }
        return len;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    // Reason: Single loop with a HashMap storing prefix sums (at most N entries)
    static int getLongestSubarrayOptimal(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Running prefix sum

            if (sum == k) maxLen = i + 1; // Whole subarray from 0 to i sums to k

            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem); // Get length from rem index to current
                maxLen = Math.max(maxLen, len); // Update max length
            }

            // Store earliest index for a prefix sum
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // Unified main method to test all approaches
    public static void main(String[] args) {
        int[] a = {-1, 1, 1};
        int k = 1;

        int bruteLen = getLongestSubarrayBrute(a, k);
        System.out.println("Brute Force -> Longest subarray length: " + bruteLen);

        int betterLen = getLongestSubarrayBetter(a, k);
        System.out.println("Better Approach -> Longest subarray length: " + betterLen);

        int optimalLen = getLongestSubarrayOptimal(a, k);
        System.out.println("Optimal Approach -> Longest subarray length: " + optimalLen);
    }
}
