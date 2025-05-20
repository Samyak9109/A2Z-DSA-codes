public class MaxConseCutiveOnes {

    /*
    Time Complexity: O(n)
    Reason: We traverse the array once, performing constant time operations per element.

    Space Complexity: O(1)
    Reason: Only a fixed number of variables (count, maxi) are used, independent of input size.
    */
    static int maxConsecutiveOnes(int[] nums) {
        int maxi = 0;  // Max consecutive 1s found
        int count = 0; // Current consecutive 1s count

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // Increase count for 1
            } else {
                count = 0; // Reset count for 0
            }
            maxi = Math.max(maxi, count); // Update max if current streak is longer
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        int ans = maxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}
