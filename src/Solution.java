public class Solution {
    static void sort012(int [] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        // Loop until mid crosses high
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap arr[low] and arr[mid], move both forward
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Just move mid pointer
                mid++;
            } else {
                // Swap arr[mid] and arr[high], move high backward
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                // Do not increment mid here as the new element at mid needs checking
            }
        }
    }
}
