import java.util.HashMap;
import java.util.Map;

public class LearnHashing {

    // Function to count frequency of elements and find the one with max and min frequency
    static void countFreq(int arr[], int n) {
        // Step 1: Create a HashMap to store the frequency of each element in the array
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Traverse through the array and count the frequencies of each element
        for (int i = 0; i < n; i++) {
            // If the element already exists in the map, increment its frequency by 1
            // Otherwise, add the element to the map with frequency 1
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        // Initialize variables to track the elements with maximum and minimum frequencies
        int maxFreq = 0, minFreq = n; // Set minFreq to n as a high initial value (max possible size)
        int maxEle = -1, minEle = -1; // These variables will store the elements with max and min frequency

        // Step 2: Traverse the HashMap to find the elements with max and min frequency
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();      // Current element (key)
            int freq = entry.getValue();   // Frequency of the current element (value)

            // Print the current element and its frequency
            System.out.println(key + " -> " + freq);

            // Check if this element's frequency is greater than the current maximum frequency
            if (freq > maxFreq) {
                maxFreq = freq;   // Update max frequency
                maxEle = key;     // Update the element with max frequency
            }

            // Check if this element's frequency is smaller than the current minimum frequency
            if (freq < minFreq) {
                minFreq = freq;   // Update min frequency
                minEle = key;     // Update the element with min frequency
            }
        }

        // Step 3: Print the final results (elements with the highest and lowest frequencies)
        System.out.println("The highest frequency element is: " + maxEle + " (Freq: " + maxFreq + ")");
        System.out.println("The lowest frequency element is: " + minEle + " (Freq: " + minFreq + ")");
    }

    // Function to count frequencies of elements using a simple approach with Map
    static void Frequency(int arr[], int n) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse through the array to count the frequency of each element
        for (int i = 0; i < n; i++) {
            // If the element is already present in the map, increment its frequency
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                // If the element is not in the map, add it with frequency 1
                map.put(arr[i], 1);
            }
        }

        // Step 2: Traverse through the map and print the frequencies of each element
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Print the current element (key) and its frequency (value)
            System.out.println(entry.getKey() + " " + entry.getValue() + " using Map");
        }
    }

    public static void main(String args[]) {
        // Input array of elements
        int arr[] = {10, 5, 10, 15, 10, 5};
        int n = arr.length; // Get the length of the array

        // Call the Frequency function to print the frequencies using the basic Map approach
        Frequency(arr, n);

        // Call the countFreq function to count frequencies and also find the min/max frequency elements
        countFreq(arr, n);
    }
}
