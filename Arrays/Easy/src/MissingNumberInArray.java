public class MissingNumberInArray {

    // 🔴 Brute Force Method
    // Time: O(n^2), Space: O(1)
    // Reason: For each number 0 to n, scan the whole array
    static int missingNumberBrute(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1; // should never reach here
    }

    // 🟡 Better Method 1: Using Hashing
    // Time: O(n), Space: O(n)
    // Reason: One pass to mark, one pass to find missing
    static int missingNumberHashing(int[] arr) {
        int n = arr.length;
        boolean[] hash = new boolean[n + 1]; // range: 0 to n

        for (int num : arr) hash[num] = true;

        for (int i = 0; i <= n; i++) {
            if (!hash[i]) return i;
        }
        return -1;
    }

    // 🟡 Better Method 2: Using Sum Formula
    // Time: O(n), Space: O(1)
    // Reason: Constant formula + one array scan
    static int missingNumberSum(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) actualSum += num;

        return expectedSum - actualSum;
    }

    // 🟢 Optimal Method: Using XOR
    // Time: O(n), Space: O(1)
    // Reason: XOR cancels out matching numbers
    static int missingNumberXOR(int[] arr) {
        int n = arr.length;
        int xorArr = 0, xorFull = 0;

        for (int i = 0; i < n; i++) {
            xorArr ^= arr[i];
            xorFull ^= i;
        }

        xorFull ^= n; // complete the 0 to n range

        return xorArr ^ xorFull;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6, 7, 8, 9}; // Missing number is 6

        System.out.println("Using Brute Force method - Missing Number: " + missingNumberBrute(arr));
        System.out.println("Using Hashing method     - Missing Number: " + missingNumberHashing(arr));
        System.out.println("Using Sum Formula method - Missing Number: " + missingNumberSum(arr));
        System.out.println("Using XOR method         - Missing Number: " + missingNumberXOR(arr));
    }
}
