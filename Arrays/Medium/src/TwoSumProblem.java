import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

    // Time Complexity: O(n^2)
    // - Two nested loops each go from 0 to n, resulting in n * n iterations.
    // - Each comparison is O(1), so total time is O(n^2).
    // Space Complexity: O(1)
    // - No extra space used other than a few variables.
    static String twoSumBruteMeth1(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip same index
                if (nums[i] + nums[j] == target) return "YES"; // Pair found
            }
        }
        return "NO"; // No pair found
    }

    // Time Complexity: O(n^2)
    // - Same nested loops as above; n * n iterations.
    // Space Complexity: O(1)
    // - Only one output array of fixed size 2 is used.
    static int[] twoSumBruteMeth2(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1; // Default values

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i; // Store indices
                    ans[1] = j;
                    return ans; // Return result
                }
            }
        }
        return ans; // No pair found
    }

    // Time Complexity: O(n)
    // - Single loop runs through array once.
    // - Each HashMap operation (put, containsKey) is O(1) on average.
    // Space Complexity: O(n)
    // - In the worst case, the HashMap stores all n elements.
    static String twoSumBetterMeth1(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) return "Yes"; // Pair found
            mpp.put(num, i); // Store current number
        }
        return "No"; // No pair found
    }

    // Time Complexity: O(n)
    // - One pass through the array with O(1) operations per element.
    // Space Complexity: O(n)
    // - HashMap may store up to n elements.
    static int[] twoSumBetterMeth2(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) {
                ans[0] = num; // Store pair
                ans[1] = moreNeeded;
                return ans; // Return result
            }
            mpp.put(num, i); // Save num with index
        }
        return ans; // No pair found
    }

    // Time Complexity: O(n log n)
    // - Sorting takes O(n log n)
    // - Two-pointer loop is O(n), so total is O(n log n)
    // Space Complexity: O(1)
    // - Sorting is in-place, and no extra structures used.
    static String twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort array

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) return "Yes"; // Pair found
            else if (sum < target) left++;   // Increase sum
            else right--;                    // Decrease sum
        }
        return "No"; // No pair found
    }

    public static void main(String args[]) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        // Brute method 1 (Yes/No)
        String ans1 = twoSumBruteMeth1(arr, target);
        System.out.println("Brute Method 1 (Yes/No): " + ans1);

        // Brute method 2 (Return indices)
        int[] ans2 = twoSumBruteMeth2(arr, target);
        System.out.println("Brute Method 2 (Indices): [" + ans2[0] + ", " + ans2[1] + "]");

        // Better method 1 (Yes/No using HashMap)
        String ans3 = twoSumBetterMeth1(arr, target);
        System.out.println("Better Method 1 (Yes/No with HashMap): " + ans3);

        // Better method 2 (Return elements using HashMap)
        int[] ans4 = twoSumBetterMeth2(arr, target);
        System.out.println("Better Method 2 (Values): [" + ans4[0] + ", " + ans4[1] + "]");

        // Optimal method (Sorting + two pointers)
        String ans5 = twoSumOptimal(arr, target);
        System.out.println("Optimal Method (Two Pointers): " + ans5);
    }
}
