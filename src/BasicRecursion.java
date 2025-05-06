public class BasicRecursion {

    // Function to print a message 'n' times
    public static void printN(int n , String message){
        // Base case: If n is less than or equal to 0, stop the recursion
        if (n <= 0) return;
        // Print the message
        System.out.println(message);
        // Recursive call with n-1
        printN(n-1, message);
    }

    // Function to print numbers from 1 to 'n'
    public static void print1toN(int n, int i){
        // Base case: If n is less than or equal to 0, stop the recursion
        if(n<= 0 ) return;
        // Print the current number (i)
        System.out.println(i);
        // Recursive call with n-1 and i+1
        print1toN(n-1 , i+1);
    }

    // Function to print numbers from 'n' to 1
    public static void printNto1(int n){
        // Base case: If n is less than or equal to 0, stop the recursion
        if(n<= 0 ) return;
        // Print the current number (n)
        System.out.println(n);
        // Recursive call with n-1
        printNto1(n-1 );
    }

    // Function to print numbers from 1 to 'n' using backtracking
    public static void printBacktrack(int n){
        // Base case: If n is 0, stop the recursion
        if (n == 0) return;
        // Recursive call first to reach the deepest level
        printBacktrack(n-1);
        // Print the number while backtracking
        System.out.println(n);
    }

    // Function to print numbers from 1 to 'n' using backtracking and printing while backtracking
    public static void printBacktrackNto1(int n, int current) {
        // Base case: If current is greater than 'n', stop the recursion
        if (current > n) return;
        // First, go to the deepest level (recursive call)
        printBacktrackNto1(n, current + 1);
        // Then print while backtracking
        System.out.println(current);
    }

    // Function to calculate the sum of numbers from 1 to 'n' using recursion
    public static int sumOfN(int n) {
        // Base case: sum of 0 is 0
        if (n == 0) return 0;
        // Recursive case: sum of 'n' + sum of previous numbers
        return n + sumOfN(n - 1);
    }

    // Function to calculate factorial of 'n' using recursion
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) return 1;
        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    // Function to reverse an array using recursion (Method 1)
    public static void reverseAnArrayMeth1(int [] arr, int start , int end){
        // Base case: If start >= end, stop the recursion
        if (start >= end) return;

        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call with next indices (start+1 and end-1)
        reverseAnArrayMeth1(arr, start+1, end-1);
    }

    // Function to reverse an array using backtracking (Method 2)
    public static void reveseAnArrayBacktraking(int []arr, int i){
        int n = arr.length;
        // Base case: If i >= n/2, stop the recursion
        if (i >= n/2) return;

        // Swap elements at index 'i' and corresponding index from the end (n-i-1)
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        // Recursive call with the next index
        reveseAnArrayBacktraking(arr, i+1);
    }

    // Function to check if a string is a palindrome using recursion (Method 1)
    public static boolean checkPalindrome(String str, int start, int end) {
        // Base case: If start >= end, the string is a palindrome
        if (start >= end) return true;
        // If characters at start and end don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) return false;
        // Recursive case: check for the next pair of characters
        return checkPalindrome(str, start+1, end-1);
    }

    // Function to check if a string is a palindrome using recursion (Method 2)
    public static boolean isPalindromeMeth2(String str, int i){
        // Base case: If i has reached or passed the middle of the string, it's a palindrome
        if (i >= str.length()/2) return true;
        // If characters at i and the corresponding index from the end don't match, it's not a palindrome
        if (str.charAt(i) != str.charAt(str.length()-i-1)) return false;
        // Recursive case: check for the next pair of characters
        return isPalindromeMeth2(str, i+1);
    }

    // Function to calculate the nth Fibonacci number using recursion
    public static int fibonacchi(int n){
        // Base case: Fibonacci of 0 is 0, Fibonacci of 1 is 1
        if (n <= 1) return n;
        // Recursive case: sum of the previous two Fibonacci numbers
        return fibonacchi(n-1) + fibonacchi(n-2);
    }

    // Function to print the Fibonacci sequence up to the nth term
    public static void printFibonacchi(int n){
        // Loop through the first 'n' terms and print the Fibonacci number
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacchi(i) + " ");
        }
    }

    public static void main(String[] args) {

        // Test cases for different functions (Uncomment to test each one)

        // Function to print "hello" 5 times
        // printN(5 , "hello");

        // Function to print numbers from 1 to 6
        // print1toN(6 , 1);

        // Function to print numbers from 5 to 1
        // printNto1(5);

        // Function to print numbers from 1 to 10 using backtracking
        // printBacktrack(10);

        // Function to print numbers from 1 to 10 using backtracking while printing during backtracking
        // printBacktrackNto1(10 , 1);

        // Function to calculate the sum of numbers from 1 to 5
        // System.out.println(sumOfN(5));

        // Function to calculate the factorial of 5
        // System.out.println(factorial(5));

        // Reverse the array using Method 1 (Recursive)
        // int [] arr = {1, 3, 4, 5, 6};
        // reverseAnArrayMeth1(arr , 0 , arr.length-1);
        // for (int a : arr) System.out.print(a);

        // Reverse the array using Method 2 (Backtracking)
        // reveseAnArrayBacktraking(arr, 0);
        // for (int b : arr) System.out.print(b);

        // Check if the string "racecar" is a palindrome
        // String s = "racecar";
        // if (checkPalindrome(s, 0 , s.length()-1)) System.out.println("True");
        // else System.out.println("False");

        // Check if the string "racecar" is a palindrome using Method 2
        // if (isPalindromeMeth2(s, 0 )) System.out.println("True");
        // else System.out.println("False");

        // Print Fibonacci sequence up to the 10th term
        printFibonacchi(10);
    }
}
