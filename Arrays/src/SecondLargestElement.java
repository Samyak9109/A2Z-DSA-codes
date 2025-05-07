public class SecondLargestElement {

    // Method to return the second-largest element (ignoring negative values)
    static int getSecondLargest(int [] arr){

        int secondLargest = -1;
        int largest =0;
//        //alt method
//        for (int var : arr) if (var>largest) largest =var;
//        for (int var : arr) if (var>secondLargest&& var<largest) secondLargest=var;
//        //Time Complexity : O(2n)
//        return secondLargest;

        //second method
        for (int var : arr) {
            if (var < 0) continue; // Skip negative numbers

            if (var > largest) {
                secondLargest = largest;
                largest = var;
            } else if (var > secondLargest && var < largest) {
                secondLargest = var;
            }
        }

        return secondLargest;
    }


    // Main method to test the getLargest method
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = {12, 45, 2, 67, 34};


        System.out.println("Second Largest element: "+ getSecondLargest(numbers));
    }
}
