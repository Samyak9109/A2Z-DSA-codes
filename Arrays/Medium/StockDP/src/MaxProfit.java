public class MaxProfit {
    static int maxProfitBrute (int [] arr) {
        int n = arr.length;
        int maxPro = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }

    static int maxProfitOptimal (int [] arr) {
        int n = arr.length;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        int maxPro = maxProfitBrute(arr);
        System.out.println("Max profit is: " + maxPro);
    }
}
