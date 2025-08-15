// Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the maximum profit achievable by buying and selling the stock at most once. 

// The stock should be purchased before selling it, and both actions cannot occur on the same day.

// Examples:
// Input: arr = [10, 7, 5, 8, 11, 9]
// Output: 6

// Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.

// Input: arr = [5, 4, 3, 2, 1]
// Output: 0

// Explanation: In this case, no transactions are made. Therefore, the maximum profit remains 0.

public class MaxStockProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int minPrice = prices[0]; // Lowest price seen so far
        int maxProfit = 0;        // Best profit found so far

        for (int i = 1; i < prices.length; i++) {
            // If selling today is better, update profit
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            // If we find a cheaper price, update minPrice
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 7, 5, 8, 11, 9};
        System.out.println(maxProfit(arr1)); // 6

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(maxProfit(arr2)); // 0
    }
}
