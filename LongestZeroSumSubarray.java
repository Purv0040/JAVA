// You are given an integer array arr of size n which contains both positive and negative integers. Your task is to find the length of the longest contiguous subarray with sum equal to 0.

// Return the length of such a subarray. If no such subarray exists, return 0.

// Examples:
// Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5

// Explanation:

// The subarray [-2, 2, -8, 1, 7] sums up to 0 and has the maximum length among all such subarrays.

// Input: arr = [2, 10, 4]
// Output: 0

// Explanation:

// There is no subarray whose elements sum to 0.

import java.util.*;

public class LongestZeroSumSubarray {
    public static int maxLen(int[] arr) {
        // HashMap to store prefix sum and its first occurrence index
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: If sum is 0, update maxLen
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: If sum was seen before, we found a zero-sum subarray
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr2 = {2, 10, 4};

        System.out.println("Output 1: " + maxLen(arr1)); // Expected 5
        System.out.println("Output 2: " + maxLen(arr2)); // Expected 0
    }
}
