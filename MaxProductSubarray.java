// Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Examples:
// Input: nums = [4, 5, 3, 7, 1, 2]
// Output: 840

// Explanation: The largest product is given by the whole array itself

// Input: nums = [-5, 0, -2]
// Output: 0

// Explanation: The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, -2].

import java.util.*;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = maxEndingHere;
            
            // Update max/min ending here
            maxEndingHere = Math.max(nums[i], Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]));
            minEndingHere = Math.min(nums[i], Math.min(temp * nums[i], minEndingHere * nums[i]));
            
            // Update result
            result = Math.max(result, maxEndingHere);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 3, 7, 1, 2};
        System.out.println("Output 1: " + maxProduct(nums1));
        // Expected 840

        int[] nums2 = {-5, 0, -2};
        System.out.println("Output 2: " + maxProduct(nums2));
        // Expected 0
    }
}
