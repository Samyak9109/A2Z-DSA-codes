import java.util.*;

public class FindIntersection {

    // 1. Brute Force (Unsorted Arrays)
    // Time: O(n * m)
    // Space: O(min(n, m)) for storing result
    static ArrayList<Integer> intersectionUnsortedBrute(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean alreadyExists = false;
            for (int k : result) {
                if (k == arr1[i]) {
                    alreadyExists = true;
                    break;
                }
            }
            if (alreadyExists) continue;

            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    result.add(arr1[i]);
                    break;
                }
            }
        }
        return result;
    }

    // 2. Better (Unsorted Arrays) - Using HashSet
    // Time: O(n + m)
    // Space: O(n + m)
    static ArrayList<Integer> intersectionUnsortedBetter(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            set1.add(arr1[i]);

        for (int i = 0; i < m; i++) {
            if (set1.contains(arr2[i]))
                resultSet.add(arr2[i]); // ensures uniqueness
        }

        return new ArrayList<>(resultSet);
    }

    // 3. Optimal for Sorted Arrays - Using Two Pointers
    // Time: O(n + m)
    // Space: O(n + m)
    static ArrayList<Integer> intersectionSortedOptimal(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue; // skip duplicates in arr1
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    // 4. Using HashMap for Frequency (Handles duplicates intersection)
    // Time: O(n + m)
    // Space: O(n + m)
    static ArrayList<Integer> intersectionWithDuplicates(int[] arr1, int[] arr2, int n, int m) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++)
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);

        for (int i = 0; i < m; i++) {
            if (freq.getOrDefault(arr2[i], 0) > 0) {
                result.add(arr2[i]);
                freq.put(arr2[i], freq.get(arr2[i]) - 1); // handle duplicates
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sorted1 = {1, 2, 2, 3, 4, 5};
        int[] sorted2 = {2, 2, 3, 5, 6};
        int[] unsorted1 = {4, 5, 9, 4, 8};
        int[] unsorted2 = {5, 4, 4, 10};

        System.out.println("Unsorted Brute: " + intersectionUnsortedBrute(unsorted1, unsorted2, unsorted1.length, unsorted2.length));
        System.out.println("Unsorted Better (HashSet): " + intersectionUnsortedBetter(unsorted1, unsorted2, unsorted1.length, unsorted2.length));
        System.out.println("Sorted Optimal (Two Pointer): " + intersectionSortedOptimal(sorted1, sorted2, sorted1.length, sorted2.length));
        System.out.println("Intersection with Duplicates: " + intersectionWithDuplicates(sorted1, sorted2, sorted1.length, sorted2.length));
    }
}
